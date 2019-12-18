package com.front.pam.pam_frontend

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class CreateBookActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)


        //przykład pobrania wartości poprzez intent
        val navbarTitle = intent.getStringExtra(CustomViewHolder.AUTHOR_NAME)
        supportActionBar?.title = navbarTitle

        val authorId = intent.getStringExtra(CustomViewHolder.AUTHOR_ID)

        val textInputBookTitle = findViewById<TextInputEditText>(R.id.text_input_book)

        val submit = findViewById<Button>(R.id.submit)
        if(submit != null && textInputBookTitle != null){
            submit.setOnClickListener {
                val bookTitle = textInputBookTitle.text.toString()

                //TODO: tutaj post na tworzenie książki
                Toast.makeText(applicationContext, "Title: $bookTitle", Toast.LENGTH_SHORT).show()
            }
        }

    }
}