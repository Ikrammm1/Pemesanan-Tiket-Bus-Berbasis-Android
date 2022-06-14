package com.riskiabiyan.pml_kelompok3.Rute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.riskiabiyan.pml_kelompok3.API.ApiRetrofit
import com.riskiabiyan.pml_kelompok3.API.ModelRute
import com.riskiabiyan.pml_kelompok3.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RuteActivity : AppCompatActivity() {
    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var Adapter: RUteAdapter
    private lateinit var listitem: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rute)
        setupList()

    }
   override fun onStart(){
       super.onStart()
       getData()
   }
    private fun setupList(){
        listitem = findViewById(R.id.list_item)
        Adapter = RUteAdapter(arrayListOf())
        listitem.adapter = Adapter
    }

    private fun getData() {
        api.data_tujuan().enqueue(object  : Callback<ModelRute>{
            override fun onResponse(call: Call<ModelRute>, response: Response<ModelRute>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.Rute
                    listData.forEach{
                        Adapter.setData(listData)
                    }
                }
            }

            override fun onFailure(call: Call<ModelRute>, t: Throwable) {
                Log.e("RuteActivity", t.toString())
            }

        })
    }




}