package com.example.prueba

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.model.PetModel
import com.example.prueba.viewmodel.PetViewModel
import com.google.android.material.button.MaterialButton



class Pets : AppCompatActivity() {

    private lateinit var  recyclerView: RecyclerView
    private lateinit var adapter: AdapterClass

    private lateinit var btnAddPet : MaterialButton

    private lateinit var petViewModel: PetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pets)
        initRV()
        initViewModel()

        // Add pet Button
        btnAddPet = findViewById(R.id.btnAddPet)
        btnAddPet.setOnClickListener{
            intent = Intent(this, PetInfo::class.java)
            startActivityForResult(intent, ADD_PET_REQUEST_CODE)
        }

    }

    private fun initRV() {
        adapter = AdapterClass(this)
        recyclerView = findViewById(R.id.recyclerPets)
        recyclerView.adapter = adapter
        recyclerView = findViewById(R.id.recyclerPets)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    private fun initViewModel() {
        petViewModel = ViewModelProvider(this)[PetViewModel::class.java]
        petViewModel.readAllData.observe(this) {
            adapter.setList(it)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_PET_REQUEST_CODE && resultCode == RESULT_OK) {

            val newPet = PetModel(
                0,
                data?.getStringExtra("SPECIES")!!,
                data.getStringExtra("BREED")!!,
                data.getStringExtra("DATE")!!,
                data.getStringExtra("NAME")!!,
                data.getStringExtra("GENDER")!!
            )
        }

    }
    companion object {
        private const val ADD_PET_REQUEST_CODE = 1
    }

}