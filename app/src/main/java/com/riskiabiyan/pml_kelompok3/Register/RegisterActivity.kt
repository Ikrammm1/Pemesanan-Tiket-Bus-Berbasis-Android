package com.riskiabiyan.pml_kelompok3.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.riskiabiyan.pml_kelompok3.API.ApiRetrofit
import com.riskiabiyan.pml_kelompok3.API.ModelRegis
import com.riskiabiyan.pml_kelompok3.Login.LoginActivity
import com.riskiabiyan.pml_kelompok3.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var btnregister: Button
    lateinit var etNama: EditText
    lateinit var etNohp: EditText
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var etAlamat: EditText
    lateinit var tvResponse: TextView
    private val api by lazy { ApiRetrofit().endpoint }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etNama = findViewById(R.id.etRegisterNama)
        etNohp = findViewById(R.id.etRegisterNohp)
        etEmail = findViewById(R.id.etRegisterEmail)
        etPassword = findViewById(R.id.etRegisterPassword)
        etAlamat = findViewById(R.id.etRegisterAlamat)
        tvResponse = findViewById(R.id.tvResponse)
        btnregister = findViewById(R.id.btnDaftar)

        txtKelogin.setOnClickListener {
            val intentkeLogin = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intentkeLogin)
        }

        btnregister.setOnClickListener {
            register()
        }
    }
    fun register() {
        if (etNama.text.isEmpty()) {
            etNama.error = "Nama tidak boleh kosong"
            etNama.requestFocus()
            return
        } else if (etNohp.text.isEmpty()) {
            etNohp.error = "No HP tidak boleh kosong"
            etNohp.requestFocus()
            return
        } else if (etEmail.text.isEmpty()) {
            etEmail.error = "Email tidak boleh kosong"
            etEmail.requestFocus()
            return
        } else if (etAlamat.text.isEmpty()) {
            etAlamat.error = "Alamat tidak boleh kosong"
            etAlamat.requestFocus()
            return
        } else if (etPassword.text.isEmpty()) {
            etPassword.error = "PW tidak boleh kosong"
            etPassword.requestFocus()
            return
        } else {
            Log.e("RegisterActivity",
                etNama.text.toString()

                )
            api.createPost(
                etNama.text.toString(),
                etNohp.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString(),
                etAlamat.text.toString()

            ).enqueue(object  : Callback<ModelRegis>{
                override fun onResponse(call: Call<ModelRegis>, response: Response<ModelRegis>) {
                    val intentDaftar = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intentDaftar)
                    Toast.makeText(this@RegisterActivity, "Silahkan Login", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<ModelRegis>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, "Kesalahan Ulangi!", Toast.LENGTH_SHORT).show()

                }

            })


        }
    }
}