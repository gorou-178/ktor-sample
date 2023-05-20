package com.example.domains

import com.example.models.Hello

class HelloUseCase {
    fun handle(name: String): Hello {
        return Hello(name)
    }
}
