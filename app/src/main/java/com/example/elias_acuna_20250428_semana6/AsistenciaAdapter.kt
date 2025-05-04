package com.example.elias_acuna_20250428_semana6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elias_acuna_20250428_semana6.entidades.Asistencia

class AsistenciaAdapter(
    private val dataSource: List<Asistencia>
) : RecyclerView.Adapter<AsistenciaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvApellido: TextView = view.findViewById(R.id.tvApellido)
        val tvRUT: TextView = view.findViewById(R.id.tvRUT)
        val tvFechaHora: TextView = view.findViewById(R.id.tvFechaHora)
        val tvTipoMarca: TextView = view.findViewById(R.id.tvTipoMarca)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_asistencia, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val asistencia = dataSource[position]
        holder.tvNombre.text = asistencia.nombre
        holder.tvApellido.text = asistencia.apellido
        holder.tvRUT.text = asistencia.rut
        holder.tvFechaHora.text = asistencia.fechaHora
        holder.tvTipoMarca.text = asistencia.tipoMarca
    }

    override fun getItemCount(): Int = dataSource.size
}
