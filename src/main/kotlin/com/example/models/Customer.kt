package com.example.models

import io.ktor.server.locations.*
import kotlinx.serialization.Serializable

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("/{id?}")
@Serializable
data class CustomerId(val id: String)

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)

val customerStorage = mutableListOf<Customer>()
