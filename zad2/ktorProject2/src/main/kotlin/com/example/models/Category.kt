package com.example.models

import org.jetbrains.exposed.sql.*

import kotlinx.serialization.*


@Serializable
data class Category(val id: Int, val name: String, val type: Boolean, val eco: Boolean)

object Categories : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val type = bool("type")
    val eco = bool("eco")

    override val primaryKey = PrimaryKey(id)
}