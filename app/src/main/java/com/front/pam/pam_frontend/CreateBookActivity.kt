package com.front.pam.pam_frontend

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.front.pam.pam_frontend.model.Author

class CreateBookActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)


        val author = intent.getSerializableExtra(CustomViewHolderBookList.BOOK_AUTHOR) as? Author

        //przykład pobrania wartości poprzez intent
        val navbarTitle = author?.firstName + " " + author?.lastName
        supportActionBar?.title = navbarTitle


        val textInputBookTitle = findViewById<TextInputEditText>(R.id.text_input_book)

        val submit = findViewById<Button>(R.id.submit)

        submit.setOnClickListener {
            if(textInputBookTitle != null){
                val bookTitle = textInputBookTitle.text.toString()

                //TODO: tutaj post na tworzenie książki
                Toast.makeText(applicationContext, "Title: $bookTitle", Toast.LENGTH_SHORT).show()
            }
        }

    }
}