package com.example.elias_acuna_20250428_semana6.entidades

data class Asistencia(
    val id: Int = 0,
    val rut: String,
    val nombre: String,
    val apellido: String,
    val fechaHora: String,
    val tipoMarca: String
)