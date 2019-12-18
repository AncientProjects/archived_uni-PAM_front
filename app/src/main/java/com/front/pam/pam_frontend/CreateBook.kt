package com.front.pam.pam_frontend

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class CreateBook: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)

        //przykład pobrania wartości poprzez intent
        val navbarTitle = intent.getStringExtra(CustomViewHolder.AUTHOR_NAME)
        supportActionBar?.title = navbarTitle
    }
}