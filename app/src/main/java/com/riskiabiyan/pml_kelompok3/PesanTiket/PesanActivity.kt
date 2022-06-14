package com.riskiabiyan.pml_kelompok3.PesanTiket

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.riskiabiyan.pml_kelompok3.API.RetrofitClient
import com.riskiabiyan.pml_kelompok3.R
import com.riskiabiyan.pml_kelompok3.RiwayatTransaksi.RiwayatTransaksi
import kotlinx.android.synthetic.main.activity_pesan.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PesanActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TeksRute = parent?.getItemAtPosition(position).toString()
        if(TeksRute.equals("SMRG-JOG")){
            rute = 1
        } else if(TeksRute.equals("JOG-JKT")){
            rute = 2
        } else if(TeksRute.equals("LMPNG-JKT")){
            rute = 3
        } else if(TeksRute.equals("JOG-BNDG")) {
            rute = 4
        } else {
            tvResponsePesan.text = "Error"
        }
    }

    private lateinit var profil : SharedPreferences
    lateinit var ptNama : EditText
    lateinit var ptKeberangkatan : EditText
    lateinit var spinner : Spinner

    var TeksRute: String = " "
    var rute: Int = 0
    var jam: String = " "
    var kategori : Int = 0
    var bus : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)

        ptNama = findViewById(R.id.etNamapembeli) as EditText
        ptKeberangkatan = findViewById(R.id.etKeberangkatan) as EditText

        rgBus.setOnCheckedChangeListener { group, checkedId ->
            bus = when(checkedId){
                R.id.rbPutra -> 1
                R.id.rbRosalia -> 2
                else -> 0
            }
        }

        rgJam.setOnCheckedChangeListener { group, checkedId ->
            jam = when(checkedId){
                R.id.rb11 -> "11:00:00"
                R.id.rb16 -> "16:00:00"
                else -> "11:00:00"
            }
        }

        rgKategori.setOnCheckedChangeListener { group, checkedId ->
            kategori = when(checkedId){
                R.id.rbVip -> 2
                R.id.rbEkonomi -> 1
                else -> 2
            }
        }

        spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.rute,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this






        btnPesan.setOnClickListener {
            buatPesanan()
        }
    }

    private fun buatPesanan() {
        profil = getSharedPreferences("Login_Session", MODE_PRIVATE)
        RetrofitClient.instance.createPesanan(

            null,
            profil.getString("id_user", null),
            kategori,
            rute,
            bus,
            ptKeberangkatan.text.toString(),
            jam,
            ptNama.text.toString(),
            "no"


        ).enqueue(object : Callback<PostResponse> {
            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                tvResponsePesan.text = t.message
            }

            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                val intentDetail = Intent(this@PesanActivity, RiwayatTransaksi::class.java)
                startActivity(intentDetail)
            }

        })
    }

//
//
//
//
//
//
//        btnPesan.setOnClickListener {
//            val keDetail = Intent (this@PesanActivity, DetailActivity::class.java)
//            startActivity(keDetail)
//        }
//
//    }
}
