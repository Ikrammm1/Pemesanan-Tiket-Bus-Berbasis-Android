package com.riskiabiyan.pml_kelompok3.API

import com.riskiabiyan.pml_kelompok3.PesanTiket.PostResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("register2.php")
    fun createPost(
        @Field("nama") nama:String,
        @Field("no_hp") no_hp: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("alamat") alamat: String
    ): Call<ModelRegis>


    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("post_email") email : String,

        @Field("post_password") password : String
    ) : Call<ResponeLogin>

    @FormUrlEncoded
    @POST("edit_user.php")
    fun Update(
        @Field("id_user") id_user: String?,
        @Field("nama") nama:String,
        @Field("no_hp") no_hp: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("alamat") alamat: String
    ): Call<ModelRegis>

    @GET("data_tujuan.php")
    fun data_tujuan() : Call<ModelRute>

    @FormUrlEncoded
    @POST("detai_tiket.php")
    fun data_transaksi(
        @Field("id_user") id_user: String?

    ): Call<ModelRiwayat>


    @FormUrlEncoded
    @POST("pesantiket.php")
    fun createPesanan(
       @Field("id_transaksi") id_transaksi: String?,
        @Field("id_user") id_user: String?,
        @Field("id_kategori") id_kategori: Int,
        @Field("id_rute") id_rute: Int,
        @Field("id_bus") id_bus: Int,
        @Field("keberangkatan") keberangkatan: String,
        @Field("jam") jam: String,
        @Field("nama_pembeli") nama_pembeli: String,
       @Field("status") status: String?
    ) :Call<PostResponse>



    @FormUrlEncoded
    @POST("edit_pesanan.php")
    fun updatePesanan(
        @Field("id_transaksi") id_transaksi: String?,
        @Field("status") status: String?
    ) :Call<PostResponse>




    @FormUrlEncoded
    @POST("delete_pesanan.php")
    fun Delete(
        @Field("id_transaksi") id_transaksi:String
    ): Call<ModelRiwayat>




}