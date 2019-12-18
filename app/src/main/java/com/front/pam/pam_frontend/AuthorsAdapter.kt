package com.front.pam.pam_frontend

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.author_row.view.*

class AuthorsAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    //tutaj w sumie dupniemy czytanie z API, bo czemu nie
    //najlepiej lista obiektów Author
    val authorNames = listOf("First author", "Second author", "Third author", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One", "Another One")

    override fun getItemCount(): Int {
        return authorNames.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.author_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val authorName = authorNames.get(position)
        //TODO: tutaj przypisujemy wartości na bieżąco do pól tekstowych i to jest do zrobienia
        holder.view.textView_author_name.text = authorName
        //TODO: tutaj trzeba przypisać obecny obiekt w sposób taki jak powyżej(magia)
        holder.author =
    }

}

class CustomViewHolder(val view: View, var author: Author? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val AUTHOR_NAME = "AUTHOR_NAME"
        val AUTHOR_ID = "AUTHOR_ID"
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, CreateBook::class.java)

            //przekazanie imienia autora, żeby się u góry wyświetliło na pasku
            intent.putExtra(AUTHOR_NAME, author?.name)
            //tutaj przekazanie poprzez intent do CreateBook ID Autora
            intent.putExtra(AUTHOR_ID, author?.id)

            view.context.startActivity(intent)
        }
    }

}