package com.example.prueba

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DogServices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dog_services)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDog)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val dogProducts = ProductProvider.dogProducts
        val adapter = ProductAdapter(dogProducts)
        recyclerView.adapter = adapter

    }
}