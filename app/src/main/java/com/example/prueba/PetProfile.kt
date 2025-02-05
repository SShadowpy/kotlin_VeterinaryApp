package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.prueba.database.PetSpecies
import com.example.prueba.model.PetModel
import com.example.prueba.viewmodel.PetViewModel
import kotlinx.coroutines.launch

class PetProfile : AppCompatActivity() {
    private lateinit var petViewModel: PetViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pet_profile)

        supportActionBar!!.hide()
        petViewModel = ViewModelProvider(this)[PetViewModel::class.java]
        val btnBack : ImageView = findViewById(R.id.btnBackProfile)

        btnBack.setOnClickListener {
            finish()
        }



        val petId = intent.getIntExtra("pet_id", -1)
        if (petId != -1) {
            loadDataFromDatabase(petId)
        } else {
            Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show()
        }

        val deletePetButton : Button = findViewById(R.id.deletePetButton)
        deletePetButton.setOnClickListener {
            petViewModel.getPetById(petId).observe(this, Observer { pet ->
                pet?.let {
                        deleteDataFromDatabase(it)
                        petViewModel.getPetById(petId).removeObservers(this)
                    }
            })
        }


    }

    private fun loadDataFromDatabase(itemId: Int) {
        petViewModel.getPetById(itemId).observe(this) { pet ->
            // Update your views
            findViewById<ImageView>(R.id.pet_image).setImageResource(when(pet.species) {
                PetSpecies.Cat.toString() -> R.drawable.cat
                PetSpecies.Dog.toString() -> R.drawable.dog
                else -> R.drawable.hamster
            })
            findViewById<EditText>(R.id.etSpecies).setText(pet.species)
            findViewById<EditText>(R.id.etBreed).setText(pet.breed)
            findViewById<EditText>(R.id.etDob).setText(pet.dob)
            findViewById<EditText>(R.id.etName).setText(pet.name)
            findViewById<EditText>(R.id.etGender).setText(pet.gender)
        }
    }

    private fun deleteDataFromDatabase(pet: PetModel) {
        petViewModel.viewModelScope.launch {
            petViewModel.deletePet(pet)
        }
    }
}
