package com.example.listahome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.cxtext.*
import kotlinx.android.synthetic.main.cxtext.view.*


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: MyAdapter

    private  lateinit var dialogView: View

    val user = mutableListOf<User>()
//            adapter.addUser(user)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       recyclerView = findViewById<RecyclerView>(R.id.recyclerViewHome)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(mutableListOf<User>())
        recyclerView.adapter = adapter

        val seuLogin = findViewById<TextView>(R.id.textView2)
        seuLogin.text = getString(R.string.ola) + " " + intent.getStringExtra("login")

        val fabButton = findViewById<FloatingActionButton>(R.id.ButtonHome)
        fabButton.setOnClickListener{

            alert()
        }
    }


     fun alert () {
         dialogView = LayoutInflater.from(this).inflate(R.layout.cxtext, null)
         val dialog = AlertDialog.Builder(this).setView(dialogView)
             .setTitle("Atividade")


         val dialogContinuation = dialog.show()


         dialogView.somar.setOnClickListener {
             dialogContinuation.dismiss()
             val atividade = dialogView.atividade.text.toString()
             adapter = MyAdapter(user)
             recyclerView.adapter = adapter
             adapter.addUser(User(atividade))

         }

         dialogView.cancelDialog.setOnClickListener{

             dialogContinuation.dismiss()
         }
         }


     }


