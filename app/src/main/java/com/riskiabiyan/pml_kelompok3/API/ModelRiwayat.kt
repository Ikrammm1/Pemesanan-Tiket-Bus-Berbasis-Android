package com.riskiabiyan.pml_kelompok3.API

data class ModelRiwayat (
    val Transaksi : List<transaksi>
)
{
    data class transaksi (
        val id_transaksi: String?,
        val id_user: String?=null,
        val nama_pembeli: String?,
        val id_kategori: String?,
        val kategori: String?,
        val id_rute: String?,
        val id_bus: String?,
        val nama_bus: String?,
        val rute: String?,
        val keberangkatan: String?,
        val jam: String?,
        val status: String?,
        val harga_rute: String?,
        val harga_kategori: String?,
        val Total: String?)
}