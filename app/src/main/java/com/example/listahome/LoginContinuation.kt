package com.example.listahome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.listahome.R

class LoginContinuation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_continuation)

        val seuLogin = findViewById<TextView>(R.id.olaSeuLogin)
        val suaSenha = findViewById<TextView>(R.id.olaSuaSenha)


        seuLogin.text = getString(R.string.ola_seu_login) + " " + intent.getStringExtra("login")
        suaSenha.text = getString(R.string.sua_senha) + " "+ intent.getStringExtra("senha")
    }
}
