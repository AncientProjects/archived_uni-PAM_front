package com.front.pam.pam_frontend

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.front.pam.pam_frontend.model.MyRequest
import com.google.gson.Gson

class RegisterActivity : AppCompatActivity() {

    private var request = MyRequest();
    //private var url = "http://83.22.80.5:8081/RestWithMongo/api/auth/login"
    private var gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nicknameInput : EditText = findViewById(R.id.nickInput)
        val nameInput : EditText = findViewById(R.id.nameInput)
        val surnameInput : EditText = findViewById(R.id.surnameInput)
        val pwdInput : EditText = findViewById(R.id.passwordInput)

        val registerButton : Button = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {

        }
    }
}
