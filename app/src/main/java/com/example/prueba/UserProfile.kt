package com.example.prueba

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.prueba.MainActivity.Companion.userInformation

class UserProfile : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_profile)

        supportActionBar?.hide()

        val profileNameTextView: TextView = findViewById(R.id.profileName)
        val profileNumberTextView: TextView = findViewById(R.id.profileNumber)
        val profileEmailTextView: TextView = findViewById(R.id.profileEmail)

        profileNameTextView.text  = userInformation[1]
        profileNumberTextView.text  = userInformation[2]
        profileEmailTextView.text  = userInformation[3]

        val backBtn: ImageView = findViewById(R.id.ivBackButton)

        backBtn.setOnClickListener {
            finish()
        }
    }
}