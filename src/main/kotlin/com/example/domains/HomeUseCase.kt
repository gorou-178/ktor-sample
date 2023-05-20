package com.example.domains

import com.example.models.Home

class HomeUseCase {
    fun handle(): Home {
        return Home("Hello World")
    }
}
