package com.example.plugins

import com.example.dao.*
import com.example.models.Categories
import com.example.models.Products
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.util.*
import io.ktor.server.plugins.contentnegotiation.*

fun Application.configureRouting() {

    routing {
        get {
      //      call.respondText("PING")
            call.respond(FreeMarkerContent("index.ftl", mapOf("products" to dao.allProducts())))
        }
        post {
            val formParameters = call.receiveParameters()
            val name = formParameters.getOrFail("name")
            val category = formParameters.getOrFail("category")
            val country = formParameters.getOrFail("country")
            val product  = dao.addNewProduct(name, category.toInt(), country)
            call.respondRedirect("/products/${product?.id}")
        }
        get("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            //call.respond(FreeMarkerContent("show.ftl", mapOf("product" to dao.product(id))))
            call.respond( dao.product(id)!! )
        }
        get("{id}/edit") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("edit.ftl", mapOf("product" to dao.product(id))))
        }
        post("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            val formParameters = call.receiveParameters()
            when (formParameters.getOrFail("_action")) {
                "update" -> {
                    val name = formParameters.getOrFail("name")
                    val category = formParameters.getOrFail("category")
                    val country = formParameters.getOrFail("country")
                    dao.editProduct(id, name, category.toInt(), country)
                    call.respondRedirect("/products/$id")
                }
                "delete" -> {
                    dao.deleteProduct(id)
                    call.respondRedirect("/products")
                }
            }
        }

        /// CATEGORY

        get("/categories") {
           // call.respondText("PING")
            call.respond(FreeMarkerContent("index.ftl", mapOf("categories" to dao.allCategories())))
        }
        post ("/categories") {
            val formParameters = call.receiveParameters()
            val name = formParameters.getOrFail("name")
            val type = formParameters.getOrFail("type")
            val eco = formParameters.getOrFail("eco")
            val category  = dao.addNewCategory(name, type.toBoolean(), eco.toBoolean())
            call.respondRedirect("/category/${category?.id}")
        }
        get("/categories/{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            //call.respond(FreeMarkerContent("show.ftl", mapOf("product" to dao.product(id))))
            call.respond( dao.category(id)!! )
        }
        get("/categories/{id}/edit") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("edit.ftl", mapOf("category" to dao.category(id))))
        }
        post("/categories/{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            val formParameters = call.receiveParameters()
            when (formParameters.getOrFail("_action")) {
                "update" -> {
                    val name = formParameters.getOrFail("name")
                    val type = formParameters.getOrFail("type")
                    val eco = formParameters.getOrFail("eco")
                    dao.editCategory(id, name, type.toBoolean(), eco.toBoolean())
                    call.respondRedirect("/categories/$id")
                }
                "delete" -> {
                    dao.deleteCategory(id)
                    call.respondRedirect("/categories")
                }
            }
        }

    }


}
