package com.example.librarymanagementapp

class BookViewModelTracker(
    private val db: BookDao
    )
    {

        suspend fun setBook(book: Book ) = db.insert( book)
        suspend fun  getBook() = db.getAlphabetizedBooks()
}
