package com.example.elias_acuna_20250428_semana6.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.elias_acuna_20250428_semana6.entidades.Asistencia

class DBHelper(context: Context) : SQLiteOpenHelper(context, "asistencia.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE asistencia (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                rut TEXT,
                nombre TEXT,
                apellido TEXT,
                fechaHora TEXT,
                tipoMarca TEXT
            )
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS asistencia")
        onCreate(db)
    }

    fun insertarAsistencia(asistencia: Asistencia): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("rut", asistencia.rut)
            put("nombre", asistencia.nombre)
            put("apellido", asistencia.apellido)
            put("fechaHora", asistencia.fechaHora)
            put("tipoMarca", asistencia.tipoMarca)
        }
        val result = db.insert("asistencia", null, values)
        return result != -1L
    }

    fun obtenerAsistencias(): List<Asistencia> {
        val db = readableDatabase
        val lista = mutableListOf<Asistencia>()
        val cursor = db.rawQuery("SELECT * FROM asistencia", null)
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Asistencia(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        return lista
    }
}
