package com.example.listahome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_cadastro_continuation.*

class cadastroContinuation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_continuation)

        val seuLogin = findViewById<TextView>(R.id.olaSeuLogin)
        val suaSenha = findViewById<TextView>(R.id.olaSuaSenha)
        val seuNome = findViewById<TextView>(R.id.seuNomeE)
        val seuCpf = findViewById<TextView>(R.id.seuCpfE)

        seuNome.text = getString(R.string.seu_nome) + " " + intent.getStringExtra("nome")
        seuCpf.text = getString(R.string.seu_cpf) + " "+ intent.getStringExtra("cpf")
        seuLogin.text = getString(R.string.ola_seu_login) + " "+ intent.getStringExtra("login")
        suaSenha.text = getString(R.string.sua_senha) + " "+ intent.getStringExtra("senha")

    }

}
