package com.example.librarymanagementapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BooksApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts

    val applicationScope = CoroutineScope( SupervisorJob())
    val database   by lazy { BookRoomDatabase.getDatabase(this,applicationScope ) }
    val repository by lazy { BookRepository(database.bookDao()) }
}