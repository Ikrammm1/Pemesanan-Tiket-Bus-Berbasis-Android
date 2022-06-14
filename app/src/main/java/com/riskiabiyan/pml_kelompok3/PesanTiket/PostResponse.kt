package com.riskiabiyan.pml_kelompok3.PesanTiket

data class PostResponse (
    val id_transaksi : Int?=null,
    val id_user : Int?=null,
    val id_kategori : Int?=null,
    val id_rute : Int?=null,
    val id_bus : Int?=null,
    val keberangkatan : String?=null,
    val jam : String?=null,
    val nama_pembeli : String?=null,
    val status: String?=null
)