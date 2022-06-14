package com.riskiabiyan.pml_kelompok3.API

import java.io.Serializable

data class ModelEdit (

    val id_user : String?,
    val nama : String?,
    val no_hp : String?,
    val email : String?,
    val password : String?,
    val alamat : String?
        ) : Serializable