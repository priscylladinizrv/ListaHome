package com.example.listahome

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import java.text.FieldPosition

class MyViewHolder(itemView:View, users: MutableList<User>):RecyclerView.ViewHolder(itemView) {


    val delete: ImageButton = itemView.findViewById((R.id.ButtonDel))
    val title: TextView = itemView.findViewById(R.id.textList)
    val spinner: TextView = itemView.findViewById(R.id.weekItem)


}