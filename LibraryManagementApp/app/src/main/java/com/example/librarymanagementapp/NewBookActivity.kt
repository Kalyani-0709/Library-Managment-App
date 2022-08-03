package com.example.librarymanagementapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText


// acept a word from the user...
class NewBookActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)
        val editBookView = findViewById<EditText>(R.id.editTextbookName)
        val editBookNumber = findViewById<EditText>(R.id.editTextbookNumber)
        val editAuthor = findViewById<EditText>(R.id.editTextAuthorName)
        val editQuantity = findViewById<EditText>(R.id.editTextQuantity)


        val button = findViewById<Button>(R.id.addBookButton)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editBookView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val bookName = editBookView.text.toString()
                val quantity : Editable? = editQuantity.text
                val author = editAuthor.text.toString()
                val bookNumber : Editable? = editBookNumber.text

                println("Quantity: $quantity")
                replyIntent.putExtra("bookname", bookName);
                replyIntent.putExtra("quantity", quantity.toString());
                replyIntent.putExtra("author", author);
                replyIntent.putExtra("booknumber", bookNumber.toString());
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

//    companion object {
//        const val EXTRA_REPLY = "com.example.android.booklistsql.REPLY"
//    }
}
