package com.front.pam.pam_frontend

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.front.pam.pam_frontend.model.Author
import com.front.pam.pam_frontend.model.Book
import kotlinx.android.synthetic.main.author_row.view.*

class AuthorsAdapter(var authors: List<Author>): RecyclerView.Adapter<CustomViewHolder>() {

    //tutaj w sumie dupniemy czytanie z API, bo czemu nie
    //najlepiej lista obiektów Author
    //val authorNames = listOf("First author", "Second author", "Third author", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One")

    override fun getItemCount(): Int {
        return authors.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.book_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val author = authors.get(position)
        holder.view.textView_author_name.text = author.firstName
        holder.view.textView2.text = author.lastName
        holder.author = author
    }

}

class CustomViewHolder(val view: View, var author: Author? = null): RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, AuthorActivity::class.java)

            intent.putExtra(CustomViewHolderBookList.BOOK_AUTHOR, author)

            view.context.startActivity(intent)
        }
    }

}