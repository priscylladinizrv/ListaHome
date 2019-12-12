package com.example.listahome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val users : MutableList<User>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false), users)

    }

    override fun getItemCount(): Int {
        return users.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = users[position].login

        holder.delete.setOnClickListener{
            users.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, users.size)
        }
        holder.spinner.text = users[position].diaSemana


        val user =users[position]




    }
    fun addUser(user: User){
        users.add(user)
        notifyItemInserted(itemCount)
    }
}