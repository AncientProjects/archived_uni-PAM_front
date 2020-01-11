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
import com.front.pam.pam_frontend.model.Utils
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class LoginActivity : AppCompatActivity() {

    private var request = MyRequest();
    //private var url = "http://83.22.80.5:8081/RestWithMongo/api/auth/login"
    private var gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var loginInput : EditText = findViewById(R.id.nickInput)
        var passwdInput : EditText = findViewById(R.id.passwordInput)
        var errorLabel : TextView = findViewById(R.id.loginErrorLabel)

        val loginButton: Button = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            println(loginInput.text)
            println(passwdInput.text)

            val nickname = loginInput.text.toString()
            val pwd = passwdInput.text.toString()

            if (nickname == null || nickname.isEmpty()) {
                errorLabel.text = "Fill all fields"
                return@setOnClickListener
            }

            if (pwd == null || pwd.isEmpty()) {
                errorLabel.text = "Fill all fields"
                return@setOnClickListener
            }

            val pwdHash = Utils().toMD5Hash(pwd)

            var httpUrl = HttpUrl.Builder()
                .scheme("http")
                .host(Connection.URL)
                .port(Connection.PORT)
                .addPathSegments("RestWithMongo/api/auth/login")
                .addQueryParameter("nickname", nickname)
                .addQueryParameter("pwdHash", pwdHash)
                .build()

            var requestBuilder = Request.Builder()
                .url(httpUrl)
                .build()

            request.GET(requestBuilder, object: Callback {
                override fun onResponse(call: Call?, response: Response) {
                    var sessionId : String
                    val responseData = response.body()?.string();
                    val setCookie = response.header("Set-Cookie");
                    if (setCookie != null && !setCookie.isEmpty()){
                        var tokens : List<String> = setCookie.split(";");
                        tokens.forEach {
                            var token = it
                            if (token.startsWith("JSESSIONID")) {
                                //sessionId = token.replace("JSESSIONID=", "")
                                sessionId = token
                                CookieContainer.setSessionId(sessionId)
                                println(sessionId)

                                //val intent = Intent()

                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                                // tutaj chyba musi byc return
                                //return@forEach
                            }
                        }
                    }
                    //val sessionId = response.header("JSESSIONID")
                    //if (sessionId != null && !sessionId.isEmpty()){

                    //}
                    //var authorsList = gson.fromJson(responseData, AuthorsList::class.java);
                    //var authorsAdapter = AuthorsAdapter(authorsList.authors);
                    runOnUiThread {
                        //    recyclerView_Authors.adapter = authorsAdapter;
                        errorLabel.text = responseData
                    }
                }

                override fun onFailure(call: Call?, e: IOException?) {
                    runOnUiThread {
                        errorLabel.text = "Error, try again"
                    }
                }
            })
        }

        val registerButton : Button = findViewById(R.id.gotoRegisterButton)
        registerButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}
