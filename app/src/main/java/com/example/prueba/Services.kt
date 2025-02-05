package com.example.prueba

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import com.shashank.sony.fancytoastlib.FancyToast

class Services : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.services)

        val dogButton : ImageView = findViewById(R.id.ivDog)
        val catButton : ImageView = findViewById(R.id.ivCat)
        val hamsterButton : ImageView = findViewById(R.id.ivHamster)
        val trainButton: CardView = findViewById(R.id.petTrainCard)
        val bathCareButton: ImageView = findViewById(R.id.ivBathCare)

        dogButton.setOnClickListener {
            val intent = Intent(this, DogServices::class.java)
            startActivity(intent)
        }
        catButton.setOnClickListener {
            val intent = Intent(this, CatServices::class.java)
            startActivity(intent)
        }
        hamsterButton.setOnClickListener {
            val intent = Intent(this, HamsterServices::class.java)
            startActivity(intent)
        }
        trainButton.setOnClickListener {
            FancyToast.makeText(this, "Coming Soon!", FancyToast.LENGTH_SHORT, FancyToast.INFO, false).show()
        }
        bathCareButton.setOnClickListener{
            val intent = Intent(this, BathCareServices::class.java)
            startActivity(intent)
        }

    }
}