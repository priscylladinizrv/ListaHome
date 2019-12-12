package com.example.listahome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ActivityLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonCancel = findViewById<Button>(R.id.buttonCancel)
        val buttonOk = findViewById<Button>(R.id.buttonOk)
        val txtLogin = findViewById<EditText>(R.id.txtLogin)
        val txtSenha = findViewById<EditText>(R.id.textSenha)




        buttonCancel.setOnClickListener{
            val intentCancel = Intent(this, home::class.java)

            startActivity(intentCancel)
        }

        buttonOk.setOnClickListener{

            val user = User(txtLogin.editableText.toString(),txtSenha.editableText.toString(),"","","")

            validUser(user)

        }

    }



    fun validUser(user: User){
        val txtLogin = findViewById<EditText>(R.id.txtLogin)

        val data = DatabaseUsuario(this)
        //montando objeto User

        //  data.insertLog(user)
        var login = ""

        // Consulta no banco de dados pelo Login
        with(data.getLog(user.login)) {
            while (moveToNext()) {
                login  = getString(getColumnIndexOrThrow("Login"))

            }
        }

        if(login == ""){
            data.insertLog(user)

            Toast.makeText(this,"Usuario ${user.login} não Registrado!", Toast.LENGTH_LONG).show()

        }else {

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("login", txtLogin.editableText.toString())
            }

            startActivity(intent)
        }

    }
}
