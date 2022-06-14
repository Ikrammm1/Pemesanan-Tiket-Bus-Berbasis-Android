package com.riskiabiyan.pml_kelompok3.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitLogin {
    private fun getRetrofitLogin(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.43.159/MyBus/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInstance() : ApiService{
        return getRetrofitLogin().create(ApiService::class.java)
    }
}