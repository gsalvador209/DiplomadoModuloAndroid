package com.cvgs.androidmodule1.exercise.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R

class MascotaAdapter(private val listaMascotas: List<Mascota>) :
        RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

class MascotaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvNombre: TextView = view.findViewById(R.id.tvNombre)
    val tvEspecie: TextView = view.findViewById(R.id.tvEspecie)
    val tvRaza: TextView = view.findViewById(R.id.tvRaza)
    val tvEdad: TextView = view.findViewById(R.id.tvEdad)
}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
    val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mascota, parent, false)
    return MascotaViewHolder(view)
}

override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
    val mascota = listaMascotas[position]
    holder.tvNombre.text = mascota.nombre
    holder.tvEspecie.text = "Especie: ${mascota.especie}"
    holder.tvRaza.text = "Raza: ${mascota.raza}"
    holder.tvEdad.text = "Edad: ${mascota.edad}"
}

override fun getItemCount(): Int = listaMascotas.size
}