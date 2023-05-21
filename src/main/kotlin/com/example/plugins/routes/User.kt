package com.example.plugins.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/user")
class User {
    @Serializable
    data class GetLocation(val id: Long)

    @Location("/detail/{id}")
    data class GetDetailLocation(val id: Long)
}

@OptIn(KtorExperimentalLocationsAPI::class)
fun Routing.userRoute() {
    accept(ContentType.Any) {
        get("/user/{id}") {
            val getLocation = call.receive<User.GetLocation>()
            call.respond(getLocation)
        }
    }

    get<User.GetDetailLocation> { param ->
        val id = param.id
        call.respondText("getDetailUser: id=$id")
    }
}
