package com.cvgs.androidmodule1.exercise.classroom.graphiccomponent.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R
import org.w3c.dom.Text

class AnimalAdapter(val list : List<AnimalEntity>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>(){
    //Los adaptadores forzosamente deben heredar de RecyclerView
    class AnimalViewHolder(view: View): RecyclerView.ViewHolder(view){
        //Requiere un View, en este caso será el item_animal.xml
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvColor = view.findViewById<TextView>(R.id.tvColor)

        fun render(animalEntity : AnimalEntity){
            tvName.text = animalEntity.name
            tvColor.text = animalEntity.color

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalViewHolder {
        //Crea una instancia del layout con le contexto
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal,parent,false) //
        //Otra forma de obtener el contexto es solicitarlo como parametro para la clase
        return AnimalViewHolder(view) //Esta función regresa el ViewHoplder creado a partir del XML de item_animal.xlm
    }

    override fun onBindViewHolder(
        holder: AnimalViewHolder,
        position: Int
    ) {
        //Esta función recibe una instancia del ViewHolder, despues usa la función render
        //para cambiar el texto de los textView. Requiere saber qué elemento es (el AnimalEntity)
        holder.render(list[position])
    }

    override fun getItemCount(): Int = list.size


}