package com.example.prueba

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.prueba.R.*
import com.shashank.sony.fancytoastlib.FancyToast
import com.example.prueba.MainActivity.Companion.userInformation


class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_dashboard)

        supportActionBar?.hide()

        val userNameTextView: TextView = findViewById(id.user)

        userNameTextView.text = userInformation[0]

        val profileButton: ImageView = findViewById(id.ivProfile)
        profileButton.setOnClickListener {
            val intent = Intent(this, UserProfile::class.java)
            startActivity(intent)
        }

        //4 main buttons
        val logoutButton: ImageView = findViewById(id.ivLogout)
        val petsButton: ImageView = findViewById(id.ivPets)
        val lostPetsButton : ImageView = findViewById(id.ivLostPets)
        val servicesButton : ImageView = findViewById(id.ivServices)

        petsButton.setOnClickListener {
            val intent = Intent(this, Pets::class.java)
            startActivity(intent)
        }

        servicesButton.setOnClickListener {
            val intent = Intent(this, Services::class.java)
            startActivity(intent)
        }

        lostPetsButton.setOnClickListener {
            val intent = Intent(this, LostPets::class.java)
            startActivity(intent)
        }
        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            FancyToast.makeText(this,"Logged Out",FancyToast.LENGTH_SHORT, FancyToast.INFO,false).show()
            startActivity(intent)
            finish()
        }

    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        onBackPressedWithExitPrompt()
    }

    private fun onBackPressedWithExitPrompt() {
        AlertDialog.Builder(this)
            .setMessage("Do you want to logout?")
            .setCancelable(true)
            .setPositiveButton("Yes") { dialog, id ->
                FancyToast.makeText(this,"Logged Out",FancyToast.LENGTH_SHORT, FancyToast.INFO,false).show()
                finish()
            }
            .setNegativeButton("No", null)
            .show()
    }
}