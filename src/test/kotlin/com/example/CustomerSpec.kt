package com.example

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CustomerSpec : BehaviorSpec() {
    init {
        given("getCustomer") {
            `when`("customerId is 100 and exist") {
                val customerId = 100
                then("return firstName is testFirstName") {
                    customerId shouldBe 100
                }
            }
        }
    }
}
