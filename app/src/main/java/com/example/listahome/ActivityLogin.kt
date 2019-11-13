package com.example.listahome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ActivityLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonCancel = findViewById<Button>(R.id.buttonCancel)
        val buttonOk = findViewById<Button>(R.id.buttonOk)
        val txtLogin = findViewById<EditText>(R.id.txtLogin)



        buttonCancel.setOnClickListener{
            finish()
        }

        buttonOk.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("login", txtLogin.editableText.toString())


            }
            startActivity(intent)



        }
    }
}
///;