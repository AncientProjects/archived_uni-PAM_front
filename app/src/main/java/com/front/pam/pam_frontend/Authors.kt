package com.front.pam.pam_frontend

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_authors.*

class Authors : AppCompatActivity() {

    var mNames: List<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authors)

        //recyclerView_Authors.setBackgroundColor(Color.BLUE)
        recyclerView_Authors.layoutManager = LinearLayoutManager(this)
        recyclerView_Authors.adapter = AuthorsAdapter()

    }


}
