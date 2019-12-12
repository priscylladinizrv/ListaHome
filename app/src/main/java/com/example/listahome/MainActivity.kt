package com.example.listahome

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.cxtext.*
import kotlinx.android.synthetic.main.cxtext.view.*
import kotlinx.android.synthetic.main.item.view.*


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: MyAdapter

    private  lateinit var dialogView: View

    private  lateinit var diaSemana: String

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


//        val week = arrayOf("Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado", "Domingo")
//        picklist.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item , week)
//        picklist.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//
//            }
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                Toast.makeText(this@MainActivity, week[position], LENGTH_LONG).show()
//            }
//
//        }
    }


     fun alert () {


         val res: Resources = resources
         val appThemeList = res.getStringArray(R.array.weekList)
         dialogView = LayoutInflater.from(this).inflate(R.layout.cxtext, null)
         val dialog = AlertDialog.Builder(this).setView(dialogView)
             .setTitle("Atividade")
//

         val dialogContinuation = dialog.show()


         dialogView.somar.setOnClickListener {
             dialogContinuation.dismiss()
             val atividade = dialogView.atividade.text.toString()
             adapter = MyAdapter(user)
             recyclerView.adapter = adapter
             adapter.addUser(User(atividade,"","","",diaSemana))

         }


         dialogView.cancelDialog.setOnClickListener{

             dialogContinuation.dismiss()
         }

         dialogView.picklist.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
             override fun onNothingSelected(parent: AdapterView<*>?) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }

             override fun onItemSelected(
                 parent: AdapterView<*>?,
                 view: View?,
                 position: Int,
                 id: Long
             ) {
                 diaSemana  = appThemeList[position]
             }

         }


         }


     }


