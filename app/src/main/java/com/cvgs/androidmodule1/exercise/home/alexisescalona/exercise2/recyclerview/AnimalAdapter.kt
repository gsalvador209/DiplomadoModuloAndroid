package com.cvgs.androidmodule1.exercise.home.alexisescalona.exercise2.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R

class AnimalAdapter(val list: List<AnimalEntity>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvColor = view.findViewById<TextView>(R.id.tvColor)

        fun render(animalEntity: AnimalEntity){
            tvName.text = animalEntity.name
            tvColor.text = animalEntity.color
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.alexis_item_animal_shared, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position])
    }
}