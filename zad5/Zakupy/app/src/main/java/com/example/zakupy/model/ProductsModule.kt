package com.example.zakupy.model

import com.google.android.datatransport.runtime.dagger.Provides
import io.realm.RealmConfiguration
import javax.inject.Singleton


private val realmVersion = 1L

@Singleton
@Provides
fun providesRealmConfig(): RealmConfiguration =
    RealmConfiguration.Builder()
        .schemaVersion(realmVersion)
        .build()