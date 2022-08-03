package com.example.librarymanagementapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class ViewBookDetails : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_book_details)

        val intent : Intent = intent

        val name = intent.getStringExtra("bookname")
        val quantity = intent.getStringExtra("quantity")
        val number = intent.getStringExtra("booknumber")
        val author = intent.getStringExtra("author")

        val bookname = findViewById<EditText>(R.id.booknamedetails)
        val booknumber = findViewById<EditText>(R.id.booknumberdetails)
        val authorname = findViewById<EditText>(R.id.authordetails)
        val quantityofbooks = findViewById<EditText>(R.id.quantitydetails)

        bookname.setText(name)
        booknumber.setText(number)
        authorname.setText(author)
        quantityofbooks.setText(quantity)


        println("Bookname : $name, quantity: $quantity, number: $number, author: $author")




    }
}