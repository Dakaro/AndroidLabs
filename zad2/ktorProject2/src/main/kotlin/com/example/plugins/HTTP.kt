package com.example.plugins

import io.ktor.server.plugins.cors.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureHTTP() {
  /*  install(CORS) {
       /* allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)
        allowHeader(HttpHeaders.Authorization)
        allowHeader("MyCustomHeader"*/

        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Head)
        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.Allow)
        allowHeader(HttpHeaders.AccessControlAllowOrigin)
        allowHeader(HttpHeaders.AccessControlAllowHeaders)
        allowHeader(HttpHeaders.AccessControlAllowMethods)
        allowHeader(HttpHeaders.AccessControlExposeHeaders)
        allowHeader(HttpHeaders.Authorization)
        exposeHeader(HttpHeaders.Allow)
        exposeHeader(HttpHeaders.Accept)
        exposeHeader(HttpHeaders.AccessControlAllowOrigin)

        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    } */
}
