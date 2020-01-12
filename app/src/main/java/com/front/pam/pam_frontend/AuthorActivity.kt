package com.front.pam.pam_frontend

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.front.pam.pam_frontend.model.Author
import kotlinx.android.synthetic.main.activity_author.*

class AuthorActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author)

        supportActionBar?.title = "Author Overview"

        val author = intent.getSerializableExtra(CustomViewHolderBookList.BOOK_AUTHOR) as? Author

        textView13_author_name.text = author?.firstName
        textView17_author_surname.text = author?.lastName

        //TODO: endpoint wypisujacy wszystkie ksiazki dla autora

//        recyclerView_books_of_author.adapter = BookListAdapter(//TODO: lista ksiazek autora here)

        button_add_a_book.setOnClickListener{
            val intent = Intent(baseContext, CreateBookActivity::class.java)

            intent.putExtra(CustomViewHolderBookList.BOOK_AUTHOR, author)

            startActivity(intent)

        }

    }
}