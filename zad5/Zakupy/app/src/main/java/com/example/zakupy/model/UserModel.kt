package com.example.zakupy.model

import androidx.room.PrimaryKey
import io.realm.RealmObject
import io.realm.annotations.Required

open class UserModel(
    @PrimaryKey
    var userId: Int = 1,
    @Required
    var name: String = "",
    var admin: Boolean = false
): RealmObject()