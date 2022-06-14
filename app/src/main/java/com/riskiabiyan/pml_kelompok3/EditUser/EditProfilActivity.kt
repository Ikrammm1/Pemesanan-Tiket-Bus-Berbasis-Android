package com.riskiabiyan.pml_kelompok3.EditUser

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.riskiabiyan.pml_kelompok3.API.ApiRetrofit
import com.riskiabiyan.pml_kelompok3.API.ModelEdit
import com.riskiabiyan.pml_kelompok3.API.ModelRegis
import com.riskiabiyan.pml_kelompok3.ProfilUser.ProfilUser
import com.riskiabiyan.pml_kelompok3.R
import kotlinx.android.synthetic.main.activity_edit_profil.*
import kotlinx.android.synthetic.main.activity_profil.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfilActivity : AppCompatActivity() {

    private lateinit var profil: SharedPreferences
    private lateinit var etNama: EditText
    private lateinit var etNohp: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAlamat: EditText
    private lateinit var etPass: EditText
    private val api by lazy { ApiRetrofit().endpoint }
    private val data by lazy { intent.getSerializableExtra("profil") as ModelEdit }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

        profil = getSharedPreferences("Login_Session", MODE_PRIVATE)
        etNama = findViewById(R.id.etRegisterNama)
        etNohp = findViewById(R.id.etRegisterNohp)
        etEmail = findViewById(R.id.etRegisterEmail)
        etAlamat = findViewById(R.id.etRegisterAlamat)
        etPass = findViewById(R.id.etRegisterPassword)


        etNama?.setText(profil.getString("nama", null))
        etNohp?.setText(profil.getString("no_hp", null))
        etEmail?.setText(profil.getString("email", null))
        etAlamat?.setText(profil.getString("alamat", null))
        etPass?.setText(profil.getString("password", null))



        btnSimpan.setOnClickListener {
            update()
        }

    }

    private fun update() {
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
        } else if (etPass.text.isEmpty()) {
            etPass.error = "PW tidak boleh kosong"
            etPass.requestFocus()
            return
        } else {
            Log.e(
                "EditProfile",
                etNama.text.toString()

            )
            api.Update(
                profil.getString("id_user", null),
                etNama.text.toString(),
                etNohp.text.toString(),
                etEmail.text.toString(),
                etPass.text.toString(),
                etAlamat.text.toString()

            ).enqueue(object : Callback<ModelRegis>{
                override fun onResponse(call: Call<ModelRegis>, response: Response<ModelRegis>) {
                    val intentUbah = Intent(this@EditProfilActivity, ProfilUser::class.java)
                    startActivity(intentUbah)
                    Toast.makeText(this@EditProfilActivity,
                        "Berhasil!, Efektif setelah logout",
                        Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<ModelRegis>, t: Throwable) {
                    Toast.makeText(this@EditProfilActivity,
                        "Gagal!",
                        Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}
