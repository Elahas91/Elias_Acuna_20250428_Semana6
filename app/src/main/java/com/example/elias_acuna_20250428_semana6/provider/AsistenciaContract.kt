package com.example.elias_acuna_20250428_semana6.provider

import android.net.Uri
import android.provider.BaseColumns

object AsistenciaContract {

    const val AUTHORITY = "com.example.elias_acuna_20250428_semana6.provider"

    const val TABLE_NAME = "asistencia"

    val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/$TABLE_NAME")

    object Columns : BaseColumns {
        const val ID = "id"
        const val RUT = "rut"
        const val NOMBRE = "nombre"
        const val APELLIDO = "apellido"
        const val FECHAHORA = "fechaHora"
        const val TIPOMARCA = "tipoMarca"
    }
}
