package com.cvgs.androidmodule1.exercise.home.ivanusielrj.homework1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R

class UsielHouseAdapter (private val houseList: List<UsielHouseEntity>) : RecyclerView.Adapter<UsielHouseAdapter.HouseViewHolder>() {

    class HouseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
        val tvSale: TextView = view.findViewById(R.id.tvSale)
        val tvCredit: TextView = view.findViewById(R.id.tvCredit)
        val tvAdress: TextView = view.findViewById(R.id.tvAdress)

        fun bind(house: UsielHouseEntity) {
            tvName.text = house.name
            tvPrice.text = house.price
            tvSale.text = house.sale
            tvCredit.text = house.credit
            tvAdress.text = house.adress
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.usiel_item_house, parent, false)
        return HouseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return houseList.size
    }

    override fun onBindViewHolder(holder: HouseViewHolder, position: Int) {
        holder.bind(houseList[position])
    }
}
