package com.example

import com.example.domains.HomeUseCase
import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class HomeTest {
    @Test
    fun `homeUseCase text is return Hello World`() {
        val useCase = HomeUseCase()
        val home = useCase.handle()
        Assertions.assertEquals("Hello World", home.toString())
    }
}
