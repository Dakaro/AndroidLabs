package com.example.models

import org.jetbrains.exposed.sql.*

import kotlinx.serialization.*


@Serializable
data class Category(val id: Int, val name: String, val liquid: Boolean, val smelly: Boolean)

object Categories : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val liquid = bool("liquid")
    val smelly = bool("smelly")

    override val primaryKey = PrimaryKey(id)
}