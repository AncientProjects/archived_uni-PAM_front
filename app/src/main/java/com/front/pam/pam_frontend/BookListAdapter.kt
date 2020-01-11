package com.front.pam.pam_frontend

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.front.pam.pam_frontend.model.Book
import kotlinx.android.synthetic.main.author_row.view.*
import kotlinx.android.synthetic.main.book_row.view.*

class BookListAdapter(var books: List<Book>): RecyclerView.Adapter<CustomViewHolderBookList>() {

    //tutaj w sumie dupniemy czytanie z API, bo czemu nie
    //najlepiej lista obiektów Author
    //val authorNames = listOf("First author", "Second author", "Third author", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One")

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolderBookList {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.book_row, parent, false)
        return CustomViewHolderBookList(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolderBookList, position: Int) {
        val book = books.get(position)
        holder.view.textView_book_title.text = book.title
        holder.book = book
    }

}

class CustomViewHolderBookList(val view: View, var book: Book? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val BOOK_TITLE = "AUTHOR_NAME"
        val AUTHOR_ID = "AUTHOR_ID"
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, CreateBookActivity::class.java)

            //przekazanie imienia autora, żeby się u góry wyświetliło na pasku
            intent.putExtra(BOOK_TITLE, book?.title)
            //tutaj przekazanie poprzez intent do CreateBookActivity ID Autora
//            intent.putExtra(AUTHOR_ID, author?.authorId)

            view.context.startActivity(intent)
        }
    }

}