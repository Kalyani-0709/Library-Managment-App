package com.example.librarymanagementapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "word_table")
//
//data class Word(@PrimaryKey @ColumnInfo(name="word") val word:String)
//                @ColumnInfo(name="quantity")val quantity:Long)


/*

@PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "word") val word: String

 */

@Entity(tableName = "book_table")
data class Book(
    @PrimaryKey @ColumnInfo(name="bookName")val bookName: String,
    @ColumnInfo(name="bookNumber")val bookNumber:Int,
    @ColumnInfo(name="author") val authorName: String,
    @ColumnInfo(name="quantity")val quantity:Int
)
