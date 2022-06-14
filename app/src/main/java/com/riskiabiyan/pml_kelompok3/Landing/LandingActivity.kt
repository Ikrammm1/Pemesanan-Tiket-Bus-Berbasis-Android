package com.riskiabiyan.pml_kelompok3.Landing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riskiabiyan.pml_kelompok3.Login.LoginActivity
import com.riskiabiyan.pml_kelompok3.R
import com.riskiabiyan.pml_kelompok3.Register.RegisterActivity
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        btnKeLogin.setOnClickListener {
            val kelogin = Intent (this@LandingActivity, LoginActivity::class.java)
            startActivity(kelogin)
        }
        
        btnKeRegister.setOnClickListener {
            val keregist = Intent (this@LandingActivity, RegisterActivity::class.java)
            startActivity(keregist)
        }
    }
}
