package com.example.plugins.routes

import com.example.models.Customer
import com.example.models.GetCustomerRequest
import com.example.models.customerStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.routing.get


@OptIn(KtorExperimentalLocationsAPI::class)
fun Route.customerRouting() {
    route("/customer") {
        get {
            call.respond(customerStorage)
        }
        get<GetCustomerRequest> { param ->
            this.context.request
            customerStorage.find { it.id == param.id }?.let {
                call.respond(it)
            }
            return@get call.respondText("No customer with id ${param.id}", status = HttpStatusCode.NotFound)
        }
        post {
            val customer = call.receive<Customer>()
            customerStorage.add(customer)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
        }
        delete<GetCustomerRequest>() {param ->
            param.id?.let {
                if (customerStorage.removeIf { it.id == param.id }) {
                    call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
                } else {
                    call.respondText("Not Found", status = HttpStatusCode.NotFound)
                }
            }
            return@delete call.respond(HttpStatusCode.BadRequest)
        }
    }
}
