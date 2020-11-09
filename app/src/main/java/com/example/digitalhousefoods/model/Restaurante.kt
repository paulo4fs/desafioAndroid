package com.example.digitalhousefoods.model

data class Restaurante(
    var nome: String,
    var endereco: String,
    var aberto: String,
    var imagem: Int,
    var prato: ArrayList<Prato>
)