package com.example.listahome

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    val title: TextView = itemView.findViewById(R.id.textList)
    val delete: ImageButton = itemView.findViewById((R.id.ButtonDel))
}