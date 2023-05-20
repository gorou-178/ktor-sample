package com.example.plugins.routes

import com.example.domains.HomeUseCase
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.homeRoute() {
    get("/") {
        val homeUseCase = HomeUseCase()
        call.respondText(homeUseCase.handle().toString())
    }
}
