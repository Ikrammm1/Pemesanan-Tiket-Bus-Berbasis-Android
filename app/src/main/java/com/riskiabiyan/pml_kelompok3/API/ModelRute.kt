package com.riskiabiyan.pml_kelompok3.API

class ModelRute (
    val Rute: List<Datarute>
) {
    data class Datarute (
        val id_rute: String?,
        val rute: String?,
        val harga_rute:String?)
}
