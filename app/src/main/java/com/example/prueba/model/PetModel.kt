package com.example.prueba.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.prueba.database.PetSpecies
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class PetModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val species: String,
    val breed: String,
    val dob: String,
    val name: String,
    val gender: String,
    var isLost: Boolean = false
) : Parcelable

{

    companion object {
        fun getAvailableBreeds(species: PetSpecies): List<String> {
            return when (species) {
                PetSpecies.Cat -> listOf("Siamese", "British Long Hair", "Persian", "Siberian")
                PetSpecies.Dog -> listOf("Bulldog", "Labrador", "Poodle", "Husky", "Chihuahua", "Malamute")
                PetSpecies.Hamster -> listOf("Syrian", "Chinese", "White Dwarf", "Campbell's Dwarf", "Roborovski Dwarf")
            }
        }

        fun getAvailableSpecies(): List<PetSpecies> {
            return listOf(PetSpecies.Cat, PetSpecies.Dog, PetSpecies.Hamster)
        }

    }
}




