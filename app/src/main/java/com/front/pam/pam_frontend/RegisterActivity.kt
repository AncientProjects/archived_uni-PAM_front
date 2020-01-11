package com.front.pam.pam_frontend

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.front.pam.pam_frontend.model.Connection
import com.front.pam.pam_frontend.model.CookieContainer
import com.front.pam.pam_frontend.model.MyRequest
import com.front.pam.pam_frontend.model.User
import com.front.pam.pam_frontend.model.Utils
import com.google.gson.Gson
import okhttp3.*
import org.w3c.dom.Text
import java.io.IOException
import java.security.MessageDigest

class RegisterActivity : AppCompatActivity() {

    private var mClient = MyRequest();
    //private var url = "http://83.22.80.5:8081/RestWithMongo/api/auth/login"
    private var gson = Gson()
    private var mtJson = MediaType.parse("application/json; charset=utf-8")
    private var md5 = MessageDigest.getInstance("MD5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nicknameInput : EditText = findViewById(R.id.nickInput)
        val nameInput : EditText = findViewById(R.id.nameInput)
        val surnameInput : EditText = findViewById(R.id.surnameInput)
        val pwdInput : EditText = findViewById(R.id.passwordInput)

        val errorLabel : TextView = findViewById(R.id.registerErrorLabel)

        val registerButton : Button = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {

            val nickname = nicknameInput.text.toString()
            val firstName = nameInput.text.toString()
            val lastName = surnameInput.text.toString()

            var pwd = pwdInput.text.toString()
            //if (pwd == null) pwd = ""
            //val pwdHashBytes = md5.digest(pwd.toByteArray()).toTypedArray()
            val pwdHash = Utils().toMD5Hash(pwd)

            var user = User(nickname, firstName, lastName, pwdHash)
            if (!user.validate()){
                errorLabel.text = "Fill all fields"
            }

            var httpUrl = HttpUrl.Builder()
                .scheme("http")
                .host(Connection.URL)
                .port(Connection.PORT)
                .addPathSegments("RestWithMongo/api/auth/register")
                //.addQueryParameter("nickname", "batman")
                //.addQueryParameter("pwdHash", "8ee60a2e00c90d7e00d5069188dc115b")
                .build()

            var requestBody = RequestBody.create(mtJson, gson.toJson(user))
            var requestBuilder = Request.Builder()
                .url(httpUrl)
                .post(requestBody)
                .build()

            mClient.POST(requestBuilder, object: Callback {
                override fun onResponse(call: Call?, response: Response) {
                    val responseData = response.body()?.string();
                    if (responseData != null && responseData.isNotEmpty()) {
                        runOnUiThread {
                            errorLabel.text = responseData
                        }
                    }
                    else {
                        var intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call?, e: IOException?) {
                    runOnUiThread {
                        errorLabel.text = "Error, try again"
                    }
                }
            })
        }
    }


}
