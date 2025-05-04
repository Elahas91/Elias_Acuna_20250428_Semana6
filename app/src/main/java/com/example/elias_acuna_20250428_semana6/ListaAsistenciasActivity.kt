package com.example.elias_acuna_20250428_semana6

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.elias_acuna_20250428_semana6.database.DBHelper
import com.example.elias_acuna_20250428_semana6.entidades.Asistencia

class ListaAsistenciasActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper
    private lateinit var recyclerView: RecyclerView
    private lateinit var asistencias: List<Asistencia>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_asistencias)

        recyclerView = findViewById(R.id.recyclerAsistencias)

        dbHelper = DBHelper(this)

        asistencias = dbHelper.obtenerAsistencias()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AsistenciaAdapter(asistencias)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Volver -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
