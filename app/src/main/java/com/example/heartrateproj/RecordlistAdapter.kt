package com.example.heartrateproj

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecordlistAdapter(private val userList : ArrayList<Record>) : RecyclerView.Adapter<RecordlistAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.record_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = userList[position]

        holder.heartRate.text = currentItem.HeartRate.toString()
        holder.spO2.text = currentItem.SpO2.toString()

    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val heartRate : TextView = itemView.findViewById(R.id.tvHRate)
        val spO2 : TextView = itemView.findViewById(R.id.tvSpO2)

    }

}