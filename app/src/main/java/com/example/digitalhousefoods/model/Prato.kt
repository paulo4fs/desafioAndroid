package com.example.digitalhousefoods.model

import java.io.Serializable

data class Prato(
    var nome: String,
    var descricao: String,
    var imagem: Int
) : Serializable