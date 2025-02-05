package com.example.prueba

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.model.PetModel
import com.example.prueba.database.PetSpecies
import com.shashank.sony.fancytoastlib.FancyToast

class AdapterClass(
    private val context: Context
) : RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    private var petList = listOf<PetModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = petList[position]
        val dataImage = when(currentItem.species) {
            PetSpecies.Cat.toString() -> R.drawable.cat
            PetSpecies.Dog.toString() -> R.drawable.dog
            else -> R.drawable.hamster
        }
        holder.rvImage.setImageResource(dataImage)
        holder.rvName.text = currentItem.name
        holder.rvCardView.setOnClickListener{
            val intent = Intent(context, PetProfile::class.java)
            intent.putExtra("pet_id", currentItem.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvImage:ImageView = itemView.findViewById(R.id.ivRecycler)
        val rvName:TextView = itemView.findViewById(R.id.tvRecycler)
        val rvCardView: CardView = itemView.findViewById(R.id.rvCardView)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<PetModel>) {
        this.petList = list
        this.notifyDataSetChanged()
    }

}
