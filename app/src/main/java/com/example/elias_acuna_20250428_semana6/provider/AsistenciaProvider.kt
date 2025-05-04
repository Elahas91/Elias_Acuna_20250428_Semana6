package com.example.elias_acuna_20250428_semana6.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class AsistenciaProvider : ContentProvider() {

    companion object {
        const val AUTHORITY = "com.example.elias_acuna_20250428_semana6.provider"
        const val TABLE_NAME = "asistencia"
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/$TABLE_NAME")

        private const val ASISTENCIAS = 1

        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, TABLE_NAME, ASISTENCIAS)
        }

        //solo rut, fechaHora y tipoMarca pa la tarea
        val PROJECTION = arrayOf("rut", "fechaHora", "tipoMarca")
    }

    private lateinit var database: SQLiteDatabase

    override fun onCreate(): Boolean {
        context?.let {
            database =
                com.example.elias_acuna_20250428_semana6.database.DBHelper(it).readableDatabase
        }
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return when (uriMatcher.match(uri)) {
            ASISTENCIAS -> database.query(
                TABLE_NAME,
                projection ?: PROJECTION, // para mostrar solo rut,fecha y tipo entrada
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
            )

            else -> throw IllegalArgumentException("URI desconocida: $uri")
        }
    }

    override fun getType(uri: Uri): String? {
        return when (uriMatcher.match(uri)) {
            ASISTENCIAS -> "vnd.android.cursor.dir/vnd.$AUTHORITY.$TABLE_NAME"
            else -> null
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }
}