package com.riskiabiyan.pml_kelompok3.Rute

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.riskiabiyan.pml_kelompok3.API.ModelRute
import com.riskiabiyan.pml_kelompok3.R

class RUteAdapter (
    val Rute : ArrayList<ModelRute.Datarute>
        ): RecyclerView.Adapter<RUteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_rute,parent,false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = Rute[position]
        holder.rute.text = data.rute
        holder.harga.text = data.harga_rute
    }

    override fun getItemCount()= Rute.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val rute = view.findViewById<TextView>(R.id.rute)
        val harga = view.findViewById<TextView>(R.id.harga)


    }
    public fun setData(data : List<ModelRute.Datarute>){
        Rute.clear()
        Rute.addAll(data)
        notifyDataSetChanged()
    }
}