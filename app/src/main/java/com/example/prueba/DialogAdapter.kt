package com.example.prueba

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.database.PetSpecies
import com.example.prueba.model.PetModel
import com.example.prueba.viewmodel.PetViewModel
import com.shashank.sony.fancytoastlib.FancyToast

class DialogAdapter(
    private val context: Context,
    private val lostAdapter: LostAdapter,
    private val petViewModel: PetViewModel
) : RecyclerView.Adapter<DialogAdapter.ViewHolderClass>() {

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
            if (!lostAdapter.containsPet(currentItem)) {
                // Mark the pet as lost
                petViewModel.markPetAsLost(currentItem)

                // Add to lost pets list
                lostAdapter.addLostPet(currentItem)
            } else {
                // Show a message or handle the case where the pet is already lost
                FancyToast.makeText(context, "This pet is already marked as lost", FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.ivRecycler)
        val rvName: TextView = itemView.findViewById(R.id.tvRecycler)
        val rvCardView: CardView = itemView.findViewById(R.id.rvCardView)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<PetModel>) {
        this.petList = list
        this.notifyDataSetChanged()
    }

}