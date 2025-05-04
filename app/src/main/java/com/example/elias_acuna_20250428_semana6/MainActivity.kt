package com.example.elias_acuna_20250428_semana6

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.elias_acuna_20250428_semana6.database.DBHelper
import com.example.elias_acuna_20250428_semana6.entidades.Asistencia
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var db: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(this)

        val etRut = findViewById<EditText>(R.id.etRut)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellido = findViewById<EditText>(R.id.etApellido)
        val rgTipoMarca = findViewById<RadioGroup>(R.id.rgTipoMarca)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnVerRegistros = findViewById<Button>(R.id.btnVerRegistros)

        btnGuardar.setOnClickListener {
            val rut = etRut.text.toString()
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val tipoMarca = if (rgTipoMarca.checkedRadioButtonId == R.id.rbEntrada) "Entrada" else "Salida"

            val fechaHora = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())

            val asistencia = Asistencia(0, rut, nombre, apellido, fechaHora, tipoMarca)

            if (db.insertarAsistencia(asistencia)) {
                Toast.makeText(this, "Asistencia registrada correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error al registrar", Toast.LENGTH_SHORT).show()
            }
        }

        btnVerRegistros.setOnClickListener {
            startActivity(Intent(this, ListaAsistenciasActivity::class.java))
        }
    }
}
