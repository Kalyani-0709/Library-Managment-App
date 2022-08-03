package com.example.librarymanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BookList : AppCompatActivity() {

    private val newBookActivityRequestCode = 1

    // before you call this ensure repository( WordsApplication) and  WordViewModelFactory is created
    private val bookViewModel: BookViewModel by viewModels {

        BookViewModelFactory((application as BooksApplication).repository)
        // in turn calls
        //  WordRepository(database.wordDao())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerviewbooklist)
        val adapter = BookListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@BookList, NewBookActivity::class.java)
            startActivityForResult(intent, newBookActivityRequestCode)
        }

        recyclerView.setOnClickListener {
            println("Clicked on recyclerView")
            val intent = Intent(this@BookList, ViewBookDetails::class.java)
            startActivity(intent)
        }

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        bookViewModel.allBooks.observe(this@BookList) { books ->
            // Update the cached copy of the words in the adapter.
            books.let { adapter.submitList( it ) }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newBookActivityRequestCode && resultCode == RESULT_OK) {

            val name = intentData?.getStringExtra("bookname")
            val quantity = intentData?.getStringExtra("quantity")

            println("Bookname : $name, quantity: $quantity")

            intentData?.getStringExtra("bookname")?.let { reply ->
                val book = name?.let { quantity?.let { it1 -> Book(it,34567,"plmnji", it1.toInt()) } }
                println("reply is $reply")
                book?.let { bookViewModel.insert(it) }
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
