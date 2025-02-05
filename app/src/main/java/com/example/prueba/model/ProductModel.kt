package com.example.prueba.model

data class ProductModel(
    val id: Int,                 // Unique identifier for the product
    val name: String,            // Name of the product
    val price: Int,           // Price of the product
    val imageResourceId: Int,    // Resource ID of the product image
    val description: String,     // Description of the product
    val category: String         // Category of the product (e.g., "Dog", "Cat", "Hamster")
)