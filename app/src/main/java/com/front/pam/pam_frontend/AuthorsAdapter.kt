package com.front.pam.pam_frontend

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.author_row.view.*

class AuthorsAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    //tutaj w sumie dupniemy czytanie z API, bo czemu nie
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
        holder.view.textView_author_name.text = authorName
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {



}