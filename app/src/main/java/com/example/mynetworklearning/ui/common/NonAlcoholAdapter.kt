package com.example.mynetworklearning.ui.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mynetworklearning.R
import com.example.mynetworklearning.data.model.DrinkNonAlcohol

class NonAlcoholAdapter (private val drinks: List<DrinkNonAlcohol>) :
    RecyclerView.Adapter<NonAlcoholAdapter.NonAlcoholViewHolder>(){

    inner class NonAlcoholViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val drinkName: TextView = itemView.findViewById(R.id.textDrinkName)
        val drinkImage: ImageView = itemView.findViewById(R.id.imageDrink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NonAlcoholViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_drink,parent,false)
        return NonAlcoholViewHolder(view)
    }

        override fun onBindViewHolder(holder: NonAlcoholViewHolder, position: Int) {
            val drink = drinks[position]
            holder.drinkName.text = drink.strDrink

            Glide.with(holder.itemView)
                .load(drink.strDrinkThumb)
                .into(holder.drinkImage)
        }
    override fun getItemCount(): Int = drinks.size
}
