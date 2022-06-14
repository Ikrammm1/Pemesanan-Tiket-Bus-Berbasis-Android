package com.riskiabiyan.pml_kelompok3.MetodeBayar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.riskiabiyan.pml_kelompok3.API.ApiRetrofit
import com.riskiabiyan.pml_kelompok3.Bayar.BayarActivity
import com.riskiabiyan.pml_kelompok3.Login.LoginActivity
import com.riskiabiyan.pml_kelompok3.PesanTiket.PesanActivity
import com.riskiabiyan.pml_kelompok3.R
import com.riskiabiyan.pml_kelompok3.RiwayatTransaksi.AdapterRiwayat
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_metode_bayar.*
import kotlinx.android.synthetic.main.activity_register.*

class MetodeBayar : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var AdapterRiwayat: AdapterRiwayat
    private lateinit var listTransaksi: RecyclerView
    private val nama_pembeli by lazy { intent.getStringExtra("nama_pembeli") }
    private val id_transaksi by lazy { intent.getStringExtra("id_transaksi") }
    private val Kategori by lazy { intent.getStringExtra("kategori") }
    private val nama_bus by lazy { intent.getStringExtra("nama_bus") }
    private val Tujuan by lazy { intent.getStringExtra("rute") }
    private val berangkat by lazy { intent.getStringExtra("keberangkatan") }
    private val Jam by lazy { intent.getStringExtra("jam") }
    private val Total by lazy { intent.getStringExtra("Total") }
    private val Status by lazy { intent.getStringExtra("status") }


    private lateinit var nama: TextView
    private lateinit var kategori: TextView
    private lateinit var rute: TextView
    private lateinit var bus: TextView
    private lateinit var keberangkatan: TextView
    private lateinit var jam: TextView
    private lateinit var total: TextView
    private lateinit var bayar: Button
    private lateinit var batal: Button
    private lateinit var sudah: TextView
    private lateinit var belum: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metode_bayar)

        setupView()



    }
    private fun setupView() {

//        nama = findViewById(R.id.detailNama)
//        kategori = findViewById(R.id.detailKateg)
//        rute = findViewById(R.id.detailRute)
//        bus = findViewById(R.id.detailBus)
//        keberangkatan = findViewById(R.id.detailKeber)
//        jam = findViewById(R.id.detailJam)
        total = findViewById(R.id.harga)
//        sudah = findViewById(R.id.detailSudah)
//        belum = findViewById(R.id.detailBelum)
//        bayar = findViewById(R.id.btnLanjut)
//        batal = findViewById(R.id.btnBatal)


//        nama.setText(nama_pembeli)
//        kategori.setText(Kategori)
//        bus.setText(nama_bus)
//        rute.setText(Tujuan)
//        keberangkatan.setText(berangkat)
//        jam.setText(Jam)
        total.setText(Total)



        btnMetBayar.setOnClickListener {
            startActivity(
                Intent(this@MetodeBayar, BayarActivity::class.java)
                    .putExtra("Total", Total)
                    .putExtra("id_transaksi", id_transaksi)
                    .putExtra("nama_pembeli", nama_pembeli)
                    .putExtra("kategori", Kategori)
                    .putExtra("rute", Tujuan)
                    .putExtra("nama_bus", nama_bus)
                    .putExtra("keberangkatan", berangkat)
                    .putExtra("jam", Jam)
                    .putExtra("Total", Total)
                    .putExtra("nama_pembeli", nama_pembeli)
                    .putExtra("status", Status)

            )

        }


    }


}
