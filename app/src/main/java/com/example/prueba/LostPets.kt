package com.example.prueba

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.databinding.BottomSheetBinding
import com.example.prueba.model.PetModel
import com.example.prueba.viewmodel.PetViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton

class LostPets : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LostAdapter
    private lateinit var dialogAdapter: DialogAdapter
    private lateinit var petViewModel: PetViewModel
    private lateinit var pets: List<PetModel>
    private var lostPetList : List<PetModel> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lost_pets)
        initViewModel()
        initRV()



        val btnMarkLostPet : MaterialButton = findViewById(R.id.btnAddLostPet)
        btnMarkLostPet.setOnClickListener {
            showBottomSheet()
        }

    }

    // Bottom Sheet Dialog
    private fun showBottomSheet() {
        val dialog = BottomSheetDialog(this)
        val dialogBinding = BottomSheetBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.setCancelable(true)
        dialogBinding.recyclerPetsDialog.adapter = dialogAdapter
        dialogBinding.recyclerPetsDialog.layoutManager = LinearLayoutManager(this)
        dialogBinding.recyclerPetsDialog.adapter = dialogAdapter

        petViewModel.readAllData.observe(this) {
            dialogAdapter.setList(it)
            dialog.dismiss()
        }

        dialog.show()

        dialogBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun initRV() {
        adapter = LostAdapter(this, lostPetList)
        dialogAdapter = DialogAdapter(this, adapter, petViewModel)
        lostPetList.size
        recyclerView = findViewById(R.id.recyclerLostPets)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    private fun initViewModel() {
        petViewModel = ViewModelProvider(this)[PetViewModel::class.java]
        petViewModel.readAllData.observe(this) {
            dialogAdapter.setList(it)
        }
        petViewModel.getLostPets().observe(this) { lostPets ->
            lostPetList = lostPets
            adapter.updateLostPetList(lostPets)
            adapter.setList(lostPets)
        }
    }
}