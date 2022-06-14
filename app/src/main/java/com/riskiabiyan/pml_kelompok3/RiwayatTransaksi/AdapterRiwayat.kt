package com.riskiabiyan.pml_kelompok3.RiwayatTransaksi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.riskiabiyan.pml_kelompok3.API.ModelRiwayat
import com.riskiabiyan.pml_kelompok3.R

class AdapterRiwayat(
    val Transaksi : ArrayList<ModelRiwayat.transaksi>,
    val listener: OnAdapterlistener



): RecyclerView.Adapter<AdapterRiwayat.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.riwayat_layout, parent, false)

    )

    override fun onBindViewHolder(holder: AdapterRiwayat.ViewHolder, position: Int) {
        val data = Transaksi[position]


        holder.txtnama.text = data.nama_pembeli
        holder.txtkateg.text = data.kategori
        holder.txtrute.text = data.rute
        holder.txtkeber.text = data.keberangkatan
        holder.txtjam.text = data.jam
        holder.txtid.text = data.id_transaksi

        when{
            data.status=="ok" ->{
                holder.txtsudah.visibility = View.VISIBLE
                holder.txtBelum.visibility = View.GONE
            }
            data.status=="no"->{
                holder.txtBelum.visibility = View.VISIBLE
                holder.txtsudah.visibility = View.GONE
            } else -> {
            holder.txtBelum.visibility = View.GONE
            holder.txtsudah.visibility = View.GONE
            }
        }

        holder.itemView.setOnClickListener{
            listener.onClick(data)
        }
        holder.imagedelete.setOnClickListener {
            listener.onDelete(data)
        }


    }

    override fun getItemCount() = Transaksi.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val txtnama = view.findViewById<TextView>(R.id.riwayatNama)
        val txtkateg = view.findViewById<TextView>(R.id.riwayatkateg)
        val txtrute = view.findViewById<TextView>(R.id.riwayatrute)
        val txtkeber = view.findViewById<TextView>(R.id.riwayatkeber)
        val txtjam = view.findViewById<TextView>(R.id.riwayatjam)
        val txtid = view.findViewById<TextView>(R.id.riwayatid)
        val imagedelete = view.findViewById<ImageView>(R.id.riwayatdelete)
        val  txtsudah = view.findViewById<TextView>(R.id.riwayatSudah)
        val txtBelum = view.findViewById<TextView>(R.id.riwayatBelum)


    }

    public fun setData(data: List<ModelRiwayat.transaksi>){
        Transaksi.clear()
        Transaksi.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterlistener {
        fun onClick(detail: ModelRiwayat.transaksi)
        fun onDelete(detail:ModelRiwayat.transaksi)
    }


}