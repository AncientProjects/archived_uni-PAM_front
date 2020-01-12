package com.front.pam.pam_frontend

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.front.pam.pam_frontend.model.Author
import com.front.pam.pam_frontend.model.Book
import kotlinx.android.synthetic.main.activity_book_list.*

class BookListActivity : AppCompatActivity() {

    private var navbarTitle = "Book List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        supportActionBar?.title = navbarTitle

        var textInputAuthorName = findViewById<TextInputEditText>(R.id.text_input_name)
        var textInputAuthorSurname = findViewById<TextInputEditText>(R.id.text_input_surname)
        var textInputCategory = findViewById<TextInputEditText>(R.id.text_input_category)

        recyclerView_books.layoutManager = LinearLayoutManager(this)

        val author1 = Author(authorId = "chujkurwa", firstName = "jprdl", lastName = "kurwadzialaj")

        //TODO: tutaj endpoint
        val books = listOf(Book(title = "First", author = author1), Book(title = "Second", author = author1), Book(title = "Third", author = author1), Book(title = "Fourth", author = author1), Book(title = "Another One", author = author1), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"), Book(title = "Another One"))



        button_search.setOnClickListener{


            recyclerView_books.adapter = BookListAdapter(books)
        }

    }

}
