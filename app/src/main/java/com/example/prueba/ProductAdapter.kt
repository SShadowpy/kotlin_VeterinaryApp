package com.example.prueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.model.PetModel
import com.example.prueba.model.ProductModel

class ProductAdapter(
    private var productList: List<ProductModel> = emptyList()
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.tvName.text = currentItem.name
        holder.tvPrice.text = currentItem.price.toString()
        holder.tvDescription.text = currentItem.description
        holder.imageView.setImageResource(currentItem.imageResourceId)
        // Bind other data to views

        holder.plusImageView.setOnClickListener {
           // onAddToCartClicked(currentItem)
        }
    }

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.ivDogRV)
        val tvName: TextView = view.findViewById(R.id.tvProductName)
        val tvPrice: TextView = view.findViewById(R.id.tvProductPrice)
        val tvDescription: TextView = view.findViewById(R.id.tvProductDescription)
        val plusImageView: ImageView = view.findViewById(R.id.plusCart)
        // Initialize other views
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_recycler, parent, false)
        return ProductAdapter.ProductViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun setList(list: List<ProductModel>) {
        this.productList = list
        this.notifyDataSetChanged()
    }
}