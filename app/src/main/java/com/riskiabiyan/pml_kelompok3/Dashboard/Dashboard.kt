package com.riskiabiyan.pml_kelompok3.Dashboard

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.card.MaterialCardView
import com.riskiabiyan.pml_kelompok3.Login.LoginActivity
import com.riskiabiyan.pml_kelompok3.PesanTiket.PesanActivity
import com.riskiabiyan.pml_kelompok3.ProfilUser.ProfilUser
import com.riskiabiyan.pml_kelompok3.R
import com.riskiabiyan.pml_kelompok3.RiwayatTransaksi.RiwayatTransaksi
import com.riskiabiyan.pml_kelompok3.Rute.RuteActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_login.*

class Dashboard : AppCompatActivity() {
    private lateinit var profil : SharedPreferences
//    private lateinit var btnUser : MaterialCardView
//    private lateinit var btnPesan : MaterialCardView
//    private lateinit var btnRiwayat : MaterialCardView
//    private lateinit var btnRute : MaterialCardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


//        btnUser = findViewById(R.id.c_user)
//        btnPesan = findViewById(R.id.c_pesantiket)
//        btnRiwayat = findViewById(R.id.c_riwayat)
//        btnRute = findViewById(R.id.c_rute)

        profil = getSharedPreferences("Login_Session", MODE_PRIVATE)
        txtname.text = profil.getString("nama", null)

        //fungsi logout
        btnLogout.setOnClickListener{
            //menghapus session
            profil.edit().clear().commit()

            val kelogin = Intent (this@Dashboard, LoginActivity::class.java)
            startActivity(kelogin)
        }

        c_user.setOnClickListener {
            val keprofil = Intent (this@Dashboard, ProfilUser::class.java)
            startActivity(keprofil)
        }

        c_pesantiket.setOnClickListener {
            val kepesan = Intent (this@Dashboard, PesanActivity::class.java)
            startActivity(kepesan)
        }
        c_riwayat.setOnClickListener {
            val keriwayat = Intent (this@Dashboard, RiwayatTransaksi::class.java)
            startActivity(keriwayat)
        }
        c_rute.setOnClickListener {
            val kerute = Intent (this@Dashboard, RuteActivity::class.java)
            startActivity(kerute)
        }





    }
}