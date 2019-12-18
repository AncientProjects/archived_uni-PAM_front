package com.front.pam.pam_frontend

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import com.front.pam.pam_frontend.model.AuthorsList
import com.front.pam.pam_frontend.model.MyRequest
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_authors.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class AuthorsActivity : AppCompatActivity() {

    var mNames: List<String> = ArrayList()
    private var request = MyRequest();
    private var url : String = "http://83.22.80.5:8081/RestWithMongo/api/author";
    private var gson = Gson();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authors)

        //recyclerView_Authors.setBackgroundColor(Color.BLUE)
        recyclerView_Authors.layoutManager = LinearLayoutManager(this)
        //recyclerView_Authors.adapter = AuthorsAdapter()

        request.GET(url, object: Callback {
            override fun onResponse(call: Call?, response: Response) {
                val responseData = response.body()?.string();
                var authorsList = gson.fromJson(responseData, AuthorsList::class.java);
                var authorsAdapter = AuthorsAdapter(authorsList.authors);
                runOnUiThread {
                    recyclerView_Authors.adapter = authorsAdapter;
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("FAILURE");
            }
        })
    }


}
