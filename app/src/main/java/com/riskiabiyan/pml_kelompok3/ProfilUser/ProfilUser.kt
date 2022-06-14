package com.riskiabiyan.pml_kelompok3.ProfilUser

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riskiabiyan.pml_kelompok3.EditUser.EditProfilActivity
import com.riskiabiyan.pml_kelompok3.Login.LoginActivity
import com.riskiabiyan.pml_kelompok3.R
import kotlinx.android.synthetic.main.activity_profil.*
import kotlinx.android.synthetic.main.activity_register.*

class ProfilUser : AppCompatActivity() {

    private lateinit var profil : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        profil = getSharedPreferences("Login_Session", MODE_PRIVATE)

        //tampil data user
        txtnama?.text = profil.getString("nama", null)
        txtnohp?.text = profil.getString("no_hp", null)
        txtemail?.text = profil.getString("email", null)
        txtalamat?.text = profil.getString("alamat", null)
        txtpassword?.text = profil.getString("password", null)


        btnUbah.setOnClickListener {
            val keEditUser = Intent (this@ProfilUser, EditProfilActivity::class.java)
            startActivity(keEditUser)
        }

    }
}
