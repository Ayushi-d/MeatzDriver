package com.meatz.meatzdriverandroid.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.meatz.meatzdriverandroid.MainActivity
import com.meatz.meatzdriverandroid.R


class LoginActivity : AppCompatActivity() {
    private lateinit var et_loginemail: EditText
    private lateinit var et_inputpassword: EditText
    private lateinit var btn_submit: Button
    private lateinit var email: String
    private lateinit var eyeButton: ImageView

    var passwordVisiblity: Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_loginemail = findViewById(R.id.et_inputemail)
        et_inputpassword = findViewById(R.id.et_inputpassword)
        btn_submit = findViewById(R.id.btn_submit)
        eyeButton = findViewById(R.id.eyeButton)
        email = et_loginemail.text.toString().trim()

        btn_submit.setOnClickListener(View.OnClickListener {
            check()
        })

        eyeButton.setOnClickListener {
            if (passwordVisiblity){
                et_inputpassword.transformationMethod = PasswordTransformationMethod.getInstance()
                passwordVisiblity = false
            }else{
                et_inputpassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                passwordVisiblity = true
            }
        }

    }


    fun check() {
        var text1 = et_loginemail.text
        var text2 = et_inputpassword.text

        if(text1.isEmpty()) {
            Toast.makeText(this, "Enter your email id", Toast.LENGTH_LONG).show()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(text1).matches()) { // using EMAIL_ADREES matcher
            Toast.makeText(this, "Please Enter Valid Email", Toast.LENGTH_LONG).show()
        } else if (text2.isEmpty()) {
            Toast.makeText(this, "Enter your Password", Toast.LENGTH_LONG).show()
        }else{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}