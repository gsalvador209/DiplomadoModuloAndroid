package com.cvgs.androidmodule1.exercise.home.ivanusielrj.exercise2.usielrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R

class UsielUserAdapter (private val users: List<UsielUserEntity>) : RecyclerView.Adapter<UsielUserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvAge: TextView = view.findViewById(R.id.tvAge)
        val tvEmail: TextView = view.findViewById(R.id.tvEmail)

        fun render(userEntity: UsielUserEntity) {
            tvName.text = userEntity.name
            tvAge.text = "Edad: ${userEntity.age}"
            tvEmail.text = userEntity.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.usiel_item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.render(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

}