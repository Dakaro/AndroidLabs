package com.example.models

import org.jetbrains.exposed.sql.*
import kotlinx.serialization.*
import io.ktor.server.plugins.contentnegotiation.*



@Serializable
data class Product(val id: Int, val name: String, val category: Int, val country: String)

object Products : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val category = (integer("category" ) references Categories.id)
    val country = varchar("country", 1024)

    override val primaryKey = PrimaryKey(id)
}