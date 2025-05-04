package com.example.elias_acuna_20250428_semana6.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.elias_acuna_20250428_semana6.provider.AsistenciaContract

class BasededatosApplication(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {

    override fun onCreate(db: SQLiteDatabase) {
        val SQL_CREATE_ENTRIES = """
            CREATE TABLE ${AsistenciaContract.TABLE_NAME} (
                ${AsistenciaContract.Columns.ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${AsistenciaContract.Columns.RUT} TEXT NOT NULL,
                ${AsistenciaContract.Columns.NOMBRE} TEXT,
                ${AsistenciaContract.Columns.APELLIDO} TEXT,
                ${AsistenciaContract.Columns.FECHAHORA} TEXT NOT NULL,
                ${AsistenciaContract.Columns.TIPOMARCA} TEXT NOT NULL
            );
        """.trimIndent()

        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${AsistenciaContract.TABLE_NAME}"
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    companion object {
        const val DATABASE_NAME = "asistencia.db"
        const val DATABASE_VERSION = 1
    }
}
