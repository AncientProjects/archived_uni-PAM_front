package com.front.pam.pam_frontend

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val booksButton : Button = findViewById(R.id.bookListButton)
        booksButton.setOnClickListener {
            val intent = Intent(this, BookList::class.java)
            startActivity(intent)
        }

        val authorsButton : Button = findViewById(R.id.authorListButton)
        authorsButton.setOnClickListener {
            val intent = Intent(this, Authors::class.java)
            startActivity(intent)
        }

        val infoButton : Button = findViewById(R.id.infoButton)
        infoButton.setOnClickListener {
            val intent = Intent(this, Info::class.java)
            startActivity(intent)
        }
    }
}
