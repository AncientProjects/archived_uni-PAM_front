package com.front.pam.pam_frontend

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.front.pam.pam_frontend.model.Author
import kotlinx.android.synthetic.main.activity_book.*

class BookActivity: AppCompatActivity() {

    var navbarTitle = "Book Overview"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        supportActionBar?.title = navbarTitle

        val title = intent.getStringExtra(CustomViewHolderBookList.BOOK_TITLE)
        val author = intent.getSerializableExtra(CustomViewHolderBookList.BOOK_AUTHOR) as? Author

        textView_book_title.text = title
        textView_book_author.text = author?.firstName + " " + author?.lastName

        button_to_author.setOnClickListener{
            val intent = Intent(baseContext, AuthorActivity::class.java)

            intent.putExtra(CustomViewHolderBookList.BOOK_AUTHOR, author)

            startActivity(intent)

        }


    }



}