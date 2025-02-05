package com.example.prueba

import android.os.Bundle
import android.widget.Toast
import android.widget.EditText
import android.content.Intent
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.text.method.PasswordTransformationMethod
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import com.shashank.sony.fancytoastlib.FancyToast



class MainActivity : AppCompatActivity() {
    companion object{
        var userInformation:Array<String> = Array(4){"a"}
    }

    private var isPasswordVisible = false
    private lateinit var emailDoneImageView: ImageView

    private val credentials = listOf(
        Pair("jorge.cardozo.uptp@gmail.com", "jorgecar01"),
        Pair("ivo.mora.uptp@gmail.com", "ivomora02"),
        Pair("lucas.martinez.uptp@gmail.com", "lucasmart03"),
        Pair("isaias.candia.uptp@gmail.com", "isacandia04"),
        Pair("a", "a")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)



        supportActionBar?.hide()

        // Login button, email and password
        val loginButton: MaterialButton = findViewById(R.id.loginButton)
        val editTextPassword : EditText = findViewById(R.id.editTextPassword)
        val ivPass: ImageView = findViewById(R.id.ivPass)
        val editTextEmail : EditText = findViewById(R.id.editTextEmail)

        emailDoneImageView = findViewById(R.id.emailDone)

        editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (isValidEmail(s.toString())) {
                    emailDoneImageView.setImageResource(R.drawable.done_green) // Green check icon
                } else {
                    emailDoneImageView.setImageResource(R.drawable.done_icon) // Default or greyed out icon
                }
            }
        })

        ivPass.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            updatePasswordVisibility(editTextPassword, isPasswordVisible)
        }

        // Login authentication
        loginButton.setOnClickListener {
            // Perform login authentication check here
            val enteredEmail = editTextEmail.text.toString()
            val enteredPassword = editTextPassword.text.toString()
            val userInfo:Array<String>
            // Check if the entered credentials match any hardcoded pair
            val isValidCredentials = credentials.any { pair ->
                pair.first == enteredEmail && pair.second == enteredPassword
            }
            if (isValidCredentials) {
                // Authentication successful, navigate to the next screen or perform other actions
                FancyToast.makeText(this, "Login Successful", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, R.drawable.vetpyiconsmall, false).show()
                val intent = Intent(this, Dashboard::class.java)
                userInformation = getUser(enteredEmail)

                startActivity(intent)

            } else {
                // Invalid credentials, show an error message
                FancyToast.makeText(this,"Invalid Credentials",FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show()
            }
        }
    }
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun getUser(enteredEmail:String):Array<String> {
        var userInfo:Array<String> = arrayOf("a","a","0905999999","a@gmail.com")
        if (enteredEmail == "jorge.cardozo.uptp@gmail.com") {
            userInfo[0] = "Welcome, Jorge"
            userInfo[1] = "Jorge Cardozo"
            userInfo[2] = "(+595) 983478975"
            userInfo[3] = enteredEmail
        }
        else if (enteredEmail == "ivo.mora.uptp@gmail.com") {
            userInfo[0] = "Welcome, Ivo"
            userInfo[1] = "Ivo Mora"
            userInfo[2] = "(+886) 905945915"
            userInfo[3] = enteredEmail
        }
        else if (enteredEmail == "lucas.martinez.uptp@gmail.com") {
            userInfo[0] = "Welcome, Lucas"
            userInfo[1] = "Lucas Martinez"
            userInfo[2] = "(+595) 992557994"
            userInfo[3] = enteredEmail
        }
        else if (enteredEmail == "isaias.candia.uptp@gmail.com") {
            userInfo[0] = "Welcome, Isaias"
            userInfo[1] = "Isaias Candia"
            userInfo[2] = "(+595) 986654945"
            userInfo[3] = enteredEmail
        }
        return userInfo
    }
    private fun updatePasswordVisibility(editText: EditText, isVisible: Boolean) {
        if (isVisible) {
            // Show password
            editText.transformationMethod = null
            editText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        } else {
            // Hide password
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
            editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
        // Move cursor to the end of the text
        editText.setSelection(editText.text.length)
    }
}
