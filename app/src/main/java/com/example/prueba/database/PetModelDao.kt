package com.example.prueba.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.prueba.model.PetModel

@Dao
interface PetModelDao {

    @Upsert
    suspend fun insertPet(pet: PetModel)

    @Delete
    suspend fun deletePet(pet: PetModel)

    @Query("SELECT * FROM PetModel ORDER BY id ASC")
    fun getAllPets(): LiveData<List<PetModel>>

    @Query("SELECT * FROM PetModel WHERE id = :id")
    fun getPetById(id: Int): LiveData<PetModel>

    @Query("SELECT * FROM PetModel WHERE isLost = 0")
    fun markPetAsLost() : LiveData<List<PetModel>>

    @Query("SELECT * FROM PetModel WHERE isLost = 1")
    fun getLostPets(): LiveData<List<PetModel>>


}