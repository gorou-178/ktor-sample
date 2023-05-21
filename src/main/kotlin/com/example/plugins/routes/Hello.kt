package com.example.plugins.routes

import com.example.domains.HelloUseCase
import com.example.models.Hello
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@OptIn(KtorExperimentalLocationsAPI::class)
fun Routing.helloRoute() {
    get<Hello> { param ->
        val useCase = HelloUseCase()
        call.respondText(useCase.handle(param.name).toString())
    }
}
