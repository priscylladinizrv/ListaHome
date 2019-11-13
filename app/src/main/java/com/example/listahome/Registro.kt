package com.example.listahome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.listahome.R
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val buttonCancelCadastro = findViewById<Button>(R.id.buttonCancelCadastro)
        val buttonOkCadastro = findViewById<Button>(R.id.buttonOkCadastro)
        val txtNome = findViewById<EditText>(R.id.txtNome)
        val txtCpf = findViewById<EditText>(R.id.textCpf)
        val txtLogin = findViewById<EditText>(R.id.txtLogin)
        val txtSenha = findViewById<EditText>(R.id.textSenha)

        buttonCancelCadastro.setOnClickListener{
            finish()
        }

        buttonOkCadastro.setOnClickListener{
            intent = Intent(this,cadastroContinuation::class.java).apply {
                putExtra("nome", txtNome.editableText.toString())
                putExtra("cpf",txtCpf.editableText.toString() )
                putExtra("login", txtLogin.editableText.toString())
                putExtra("senha", txtSenha.editableText.toString())
            }
            startActivity(intent)
        }
    }
}
