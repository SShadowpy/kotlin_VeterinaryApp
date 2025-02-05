package com.example.prueba

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BathCareServices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bath_care_services)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerBathCare)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val bathCareProducts = ProductProvider.bathcareProducts
        val adapter = ProductAdapter(bathCareProducts)
        recyclerView.adapter = adapter
    }
}