package com.front.pam.pam_frontend

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.widget.LinearLayoutManager
import android.view.View
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

        //TODO: tutaj endpoint
        val books = listOf(Book("First"), Book("Second"), Book("Third"), Book("Fourth"), Book("Another One"), Book("Another One"), Book("Another One"), Book("Another One"), Book("Another One"), Book("Another One"), Book("Another One"), Book("Another One"), Book("Another One"))



        button_search.setOnClickListener{


            recyclerView_books.adapter = BookListAdapter(books)
        }

    }

}
