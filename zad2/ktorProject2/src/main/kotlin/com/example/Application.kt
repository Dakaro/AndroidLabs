package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.example.models.*
import com.example.dao.*
import io.ktor.http.*
import io.ktor.http.HttpMethod.Companion.Delete
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import java.text.DateFormat
import io.ktor.server.plugins.cors.*


fun main() {
    embeddedServer(Netty, port = 4040, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()
    configureHTTP()
    configureSerialization()
    configureRouting()
    install(CORS){
        anyHost()
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
    }
}
