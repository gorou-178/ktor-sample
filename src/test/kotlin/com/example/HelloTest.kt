package com.example

import com.example.domains.HelloUseCase
import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class HelloTest {
    @Test
    fun `helloUseCase name is return Hello World name`() {
        val name = "taro"
        val useCase = HelloUseCase()
        val hello = useCase.handle(name)
        Assertions.assertEquals("Hello World taro", hello.toString())
    }
}
