package com.example.plugins.routes

import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/user")
class User {
    @Location("/{id}")
    data class GetLocation(val id: Long)

    @Location("/detail/{id}")
    data class GetDetailLocation(val id: Long)
}

@OptIn(KtorExperimentalLocationsAPI::class)
fun Routing.userRoute() {
    get<User.GetLocation> { param ->
        val id = param.id
        call.respondText("getUser: id=$id")
    }
    get<User.GetDetailLocation> { param ->
        val id = param.id
        call.respondText("getDetailUser: id=$id")
    }
}
