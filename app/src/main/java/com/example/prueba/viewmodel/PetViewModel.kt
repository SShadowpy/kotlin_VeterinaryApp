package com.example.prueba.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.prueba.model.PetModel
import com.example.prueba.database.PetModelDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch

class PetViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<PetModel>>
    private val petDao = PetModelDatabase.getDatabase(application).PetModelDao()

    init {
        readAllData = petDao.getAllPets()
    }

    fun addPet(pet: PetModel) {
        viewModelScope.launch(Dispatchers.IO) {
            petDao.insertPet(pet)
        }
    }

    fun deletePet(pet : PetModel) {
        viewModelScope.launch(Dispatchers.IO) {
            petDao.deletePet(pet)
        }
    }

    fun getPetById(id: Int): LiveData<PetModel> {
        return petDao.getPetById(id)
    }

    fun markPetAsLost(pet : PetModel) {
        viewModelScope.launch(Dispatchers.IO) {
            pet.isLost = true
            petDao.insertPet(pet)
        }
    }

    fun getLostPets(): LiveData<List<PetModel>> {
        return petDao.getLostPets()
    }

}
