package com.riskiabiyan.pml_kelompok3.RiwayatTransaksi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.riskiabiyan.pml_kelompok3.API.ApiRetrofit
import com.riskiabiyan.pml_kelompok3.API.ModelRiwayat
import com.riskiabiyan.pml_kelompok3.DetailTicket.DetailActivity
import com.riskiabiyan.pml_kelompok3.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RiwayatTransaksi : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var AdapterRiwayat: AdapterRiwayat
    private lateinit var listTransaksi: RecyclerView
    private lateinit var profil : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat_transaksi)
        setupList()
    }
    override fun onStart() {
        super.onStart()
        getTransaksi()
    }
    private fun setupList() {
        listTransaksi = findViewById(R.id.list_transaksi)
        AdapterRiwayat = AdapterRiwayat(arrayListOf(), object : AdapterRiwayat.OnAdapterlistener{
            override fun onClick(detail: ModelRiwayat.transaksi) {
                startActivity(
                    Intent(this@RiwayatTransaksi, DetailActivity::class.java)
                    .putExtra("nama_pemesan", detail.nama_pembeli)
                    .putExtra("id_transaksi", detail.id_transaksi)
                    .putExtra("kategori", detail.kategori)
                    .putExtra("rute", detail.rute)
                    .putExtra("nama_bus", detail.nama_bus)
                    .putExtra("keberangkatan", detail.keberangkatan)
                    .putExtra("jam", detail.jam)
                    .putExtra("Total", detail.Total)
                    .putExtra("nama_pembeli", detail.nama_pembeli)
                    .putExtra("status", detail.status)
                )
            }

            override fun onDelete(detail: ModelRiwayat.transaksi) {
                api.Delete(detail.id_transaksi!!)
                    .enqueue(object :Callback<ModelRiwayat>{
                        override fun onResponse(
                            call: Call<ModelRiwayat>,
                            response: Response<ModelRiwayat>
                        ) {
                            if (response.isSuccessful){
                                Toast.makeText(
                                    this@RiwayatTransaksi,
                                    "Data Berhasil Dihapus!",
                                    Toast.LENGTH_SHORT).show()
                                getTransaksi()
                            }
                        }

                        override fun onFailure(call: Call<ModelRiwayat>, t: Throwable) {

                        }

                    })
            }

        })
        listTransaksi.adapter = AdapterRiwayat
    }

    private fun getTransaksi() {
        profil = getSharedPreferences("Login_Session", MODE_PRIVATE)
        api.data_transaksi(
            profil.getString("id_user", null)
        ).enqueue(object : Callback<ModelRiwayat> {
            override fun onResponse(call: Call<ModelRiwayat>, response: Response<ModelRiwayat>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.Transaksi
                    AdapterRiwayat.setData(listData)
                }
            }

            override fun onFailure(call: Call<ModelRiwayat>, t: Throwable) {
                Log.e("Riwayat", t.toString())
            }

        })

    }
}
