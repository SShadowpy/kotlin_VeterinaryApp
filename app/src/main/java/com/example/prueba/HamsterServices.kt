package com.example.prueba

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HamsterServices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hamster_services)       //estiy haciendo ahora cat srevices

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerHamster) //crear recycler cat
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val catProducts = ProductProvider.hamsterProducts   //cambiar a catProducts
        val adapter = ProductAdapter(catProducts)
        recyclerView.adapter = adapter

    }
}