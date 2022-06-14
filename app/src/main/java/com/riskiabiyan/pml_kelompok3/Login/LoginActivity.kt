package com.riskiabiyan.pml_kelompok3.Login

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.riskiabiyan.pml_kelompok3.API.ApiRetrofit
import com.riskiabiyan.pml_kelompok3.API.ResponeLogin
import com.riskiabiyan.pml_kelompok3.API.RetrofitLogin
import com.riskiabiyan.pml_kelompok3.Dashboard.Dashboard
import com.riskiabiyan.pml_kelompok3.R
import com.riskiabiyan.pml_kelompok3.Register.RegisterActivity
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private var email: String = ""
    private  var pass: String = ""
    private lateinit var profil : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //cek session
        profil = getSharedPreferences("Login_Session", MODE_PRIVATE)
        if(profil.getString("id_user",null) !=null) {
            startActivity(Intent(this@LoginActivity, Dashboard::class.java))
            finish()
        } else {
            Toast.makeText(this@LoginActivity, "GAGAL", Toast.LENGTH_SHORT)
        }


        btnLogin.setOnClickListener {
            email = etRegisterEmail.text.toString()
            pass = etRegisterPassword.text.toString()

            when{
                email == "" ->{
                    etRegisterEmail.error = "Email Tidak Boleh Kosong!"
                }
                pass == "" -> {
                    etRegisterPassword.error = "Password Tidak Boleh Kosong!"
                }
                else -> {
                    getUser()
//                    val kedashboard = Intent (this@LoginActivity, Dashboard::class.java)
//                    startActivity(kedashboard)
                }
            }

        }

        txtKedaftar.setOnClickListener {
            val kedaftar = Intent (this@LoginActivity, RegisterActivity::class.java)
            startActivity(kedaftar)
        }

    }

    private fun getUser() {
        val api = RetrofitLogin().getInstance()
        api.login(email, pass).enqueue(object :Callback<ResponeLogin>{
            override fun onResponse(call: Call<ResponeLogin>, response: Response<ResponeLogin>) {
                if(response.isSuccessful){

                    //fungsi session
                    getSharedPreferences("Login_Session", MODE_PRIVATE)
                        .edit()
                        .putString("id_user", response.body()?.payload?.id_user)
                        .putString("nama", response.body()?.payload?.nama)
                        .putString("no_hp", response.body()?.payload?.no_hp)
                        .putString("email", response.body()?.payload?.email)
                        .putString("password", response.body()?.payload?.password)
                        .putString("alamat", response.body()?.payload?.alamat)
                        .apply()

                    if(response.body()?.response == true){
                        startActivity(Intent(this@LoginActivity, Dashboard::class.java))
                        finish()
//                        val kedashboard = Intent (this@LoginActivity, Dashboard::class.java)
//                          startActivity(kedashboard)
                    }else{
                        Toast.makeText(this@LoginActivity, "GAGAL", Toast.LENGTH_SHORT)
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Kesalahan", Toast.LENGTH_SHORT)
                }
            }

            override fun onFailure(call: Call<ResponeLogin>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}
