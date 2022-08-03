package com.example.librarymanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AdminDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        var viewbooklist = findViewById<Button>(R.id.viewbooklist)
//        var addbook = findViewById<ImageView>(R.id.addbook)

        viewbooklist.setOnClickListener {
            val intent = Intent(this, BookList::class.java)
            startActivity(intent)
        }

//        addbook.setOnClickListener {
//            val intent = Intent(this, AddBook::class.java)
//            startActivity(intent)
//        }
    }
}