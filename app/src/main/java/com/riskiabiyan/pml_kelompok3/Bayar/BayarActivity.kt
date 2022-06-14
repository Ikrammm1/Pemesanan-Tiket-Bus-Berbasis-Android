package com.riskiabiyan.pml_kelompok3.Bayar

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.riskiabiyan.pml_kelompok3.API.ApiRetrofit
import com.riskiabiyan.pml_kelompok3.API.ModelEdit
import com.riskiabiyan.pml_kelompok3.API.ModelRegis
import com.riskiabiyan.pml_kelompok3.MetodeBayar.MetodeBayar
import com.riskiabiyan.pml_kelompok3.PesanTiket.PostResponse
import com.riskiabiyan.pml_kelompok3.ProfilUser.ProfilUser
import com.riskiabiyan.pml_kelompok3.R
import com.riskiabiyan.pml_kelompok3.RiwayatTransaksi.AdapterRiwayat
import com.riskiabiyan.pml_kelompok3.RiwayatTransaksi.RiwayatTransaksi
import kotlinx.android.synthetic.main.activity_bayar.*
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BayarActivity : AppCompatActivity() {

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


    private lateinit var profil: SharedPreferences
    private lateinit var etNama: EditText
    private lateinit var etNohp: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAlamat: EditText
    private lateinit var etPass: EditText
    private val data by lazy { intent.getSerializableExtra("profil") as ModelEdit }


    private lateinit var nama: TextView
    private lateinit var kategori: TextView
    private lateinit var rute: TextView
    private lateinit var bus: TextView
    private lateinit var keberangkatan: TextView
    private lateinit var jam: TextView
    private lateinit var total: TextView
    private lateinit var edtNominal: EditText
    private lateinit var bayar: Button
    private lateinit var batal: Button
    private lateinit var sudah: TextView
    private lateinit var belum: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bayar)

        setupView()


    }
    private fun setupView() {

//        nama = findViewById(R.id.detailNama)
//        kategori = findViewById(R.id.detailKateg)
//        rute = findViewById(R.id.detailRute)
//        bus = findViewById(R.id.detailBus)
//        keberangkatan = findViewById(R.id.detailKeber)
//        jam = findViewById(R.id.detailJam)
        total = findViewById(R.id.bayarharga)
        edtNominal = findViewById(R.id.edNominal)

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


        btnBayar.setOnClickListener {
            updatePesanan()
            edtNominal.text.toString()



        }
    }
    private fun updatePesanan() {

            api.updatePesanan(
                id_transaksi,
                "ok"
            ).enqueue(object :Callback<PostResponse>{
                override fun onResponse(
                    call: Call<PostResponse>,
                    response: Response<PostResponse>
                ) {
                    Toast.makeText(this@BayarActivity,
                        "Data Berhasil Diubah!",
                        Toast.LENGTH_SHORT).show()
                    val keRiwayat = Intent (this@BayarActivity, RiwayatTransaksi::class.java)
                    startActivity(keRiwayat)

                }

                override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                    Toast.makeText(this@BayarActivity,
                        "Gagal!",
                        Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

