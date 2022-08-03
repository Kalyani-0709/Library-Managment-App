package com.example.librarymanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val loginBtn = findViewById<Button>(R.id.button_login)
        val resetBtn = findViewById<Button>(R.id.button_reset)

        resetBtn.setOnClickListener {
            userName.setText("")
            password.setText("")
        }

        loginBtn.setOnClickListener {
            login(userName, password)
        }
    }

    private fun login(userName: EditText, password: EditText) {

        if(userName.text.toString() == ("admin") && password.text.toString() == ("admin123")) {
            Toast.makeText(this@MainActivity,"${userName.text} Login successful..!!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, AdminDashboard::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this@MainActivity, "Unsuccessful login!!",Toast.LENGTH_LONG).show()
        }
    }
}