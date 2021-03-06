package com.example.tzva_naloga_1.database

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ItemsApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    private val applicationScope = CoroutineScope(SupervisorJob())
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { ItemRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ItemRepository(database.itemDao()) }
}