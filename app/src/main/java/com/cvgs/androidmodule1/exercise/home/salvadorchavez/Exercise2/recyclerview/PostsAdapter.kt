package com.cvgs.androidmodule1.exercise.home.salvadorchavez.Exercise2.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R

class PostsAdapter(val list : List<PostEntity>) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>(){
    //Los adaptadores forzosamente deben heredar de RecyclerView
    class PostViewHolder(view: View): RecyclerView.ViewHolder(view){
        //Requiere un View, en este caso será el item_animal.xml
        val tvUserName = view.findViewById<TextView>(R.id.tvUserName)
        val tvPostDate = view.findViewById<TextView>(R.id.tvDate)
        val tvPostContent = view.findViewById<TextView>(R.id.tvPostContent)

        fun render(postEntity: PostEntity){
            tvUserName.text = postEntity.username
            tvPostDate.text = postEntity.date
            tvPostContent.text = postEntity.postContent

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        //Crea una instancia del layout con le contexto
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false) //
        //Otra forma de obtener el contexto es solicitarlo como parametro para la clase
        return PostViewHolder(view) //Esta función regresa el ViewHoplder creado a partir del XML de item_animal.xlm
    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {
        //Esta función recibe una instancia del ViewHolder, despues usa la función render
        //para cambiar el texto de los textView. Requiere saber qué elemento es (el AnimalEntity)
        holder.render(list[position])
    }

    override fun getItemCount(): Int = list.size


}