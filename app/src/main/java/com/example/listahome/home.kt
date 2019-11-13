package com.example.listahome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home);

        val buttonLogin1 = findViewById<Button>(R.id.buttonLogin)
        val buttonCadastro1 = findViewById<Button>(R.id.buttonCadastro)

        buttonLogin1.setOnClickListener{
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
        }

        buttonCadastro1.setOnClickListener{
            val intent = Intent(this,Registro::class.java)
            startActivity(intent)

        }
    }
}
