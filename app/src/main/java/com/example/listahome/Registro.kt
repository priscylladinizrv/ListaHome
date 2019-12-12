package com.example.listahome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.listahome.R
import kotlinx.android.synthetic.main.activity_registro.*
import java.io.Console

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val buttonCancelCadastro = findViewById<Button>(R.id.buttonCancelCadastro)
        val buttonOkCadastro = findViewById<Button>(R.id.buttonOkCadastro)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val txtCpf = findViewById<EditText>(R.id.textCpf)
        val txtLogin = findViewById<EditText>(R.id.txtLogin)
        val txtSenha = findViewById<EditText>(R.id.textSenha)



        buttonCancelCadastro.setOnClickListener{
            finish()
        }


        buttonOkCadastro.setOnClickListener{
            intent = Intent(this,ActivityLogin::class.java).apply {
                putExtra("email", txtEmail.editableText.toString())
                putExtra("cpf",txtCpf.editableText.toString() )
                putExtra("login", txtLogin.editableText.toString())
                putExtra("senha", txtSenha.editableText.toString())
            }
            startActivity(intent)

            val user = User(txtLogin.editableText.toString(),txtEmail.editableText.toString(),txtSenha.editableText.toString(),txtCpf.editableText.toString(),"")

            validUser(user)



        }
    }

    fun validUser(user: User){


        val data = DatabaseUsuario(this)


        var login = ""

        with(data.getLog(user.login)) {
            while (moveToNext()) {
                login  = getString(getColumnIndexOrThrow("Login"))

            }
        }

        if(login == ""){
            data.insertLog(user)
            Toast.makeText(this,"Usuario ${user.login} cadastrado com sucesso!!",Toast.LENGTH_LONG).show()

        }else {
            Toast.makeText(this,"Usuario ${user.login} já existe!!",Toast.LENGTH_LONG).show()
        }

    }
}
