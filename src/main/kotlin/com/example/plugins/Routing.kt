package com.example.plugins

import com.example.plugins.routes.helloRoute
import com.example.plugins.routes.homeRoute
import com.example.plugins.routes.userRoute
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        homeRoute()
        helloRoute()
        userRoute()
    }
}
