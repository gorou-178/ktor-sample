package com.example.models

import io.ktor.server.locations.*

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/hello/{name}")
data class Hello(val name:String) {
    override fun toString():String = "Hello World $name";
}
