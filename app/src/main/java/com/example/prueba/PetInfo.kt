package com.example.prueba

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.prueba.database.Gender
import com.example.prueba.model.PetModel
import com.example.prueba.database.PetSpecies
import com.example.prueba.viewmodel.PetViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone
import com.example.prueba.databinding.PetInfoBinding
import com.google.android.material.datepicker.CalendarConstraints
import java.util.Date
import android.app.DatePickerDialog
import android.widget.DatePicker

private lateinit var editTextDate: TextInputEditText
private lateinit var binding: PetInfoBinding
private lateinit var petViewModel: PetViewModel



class PetInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PetInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editTextName: EditText = findViewById(R.id.etName)

        // Select species, change breed options
        val speciesAutoCompleteTextView: AutoCompleteTextView = findViewById(R.id.selectSpecies)
        val breedAutoCompleteTextView: AutoCompleteTextView = findViewById(R.id.selectBreed)
        val speciesAdapter =
            ArrayAdapter(this, R.layout.dropdown_item, PetModel.getAvailableSpecies())

        speciesAutoCompleteTextView.setAdapter(speciesAdapter)

        speciesAutoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val selectedSpecies = speciesAdapter.getItem(position) as PetSpecies
            val breedAdapter = ArrayAdapter(
                this,
                R.layout.dropdown_item,
                PetModel.getAvailableBreeds(selectedSpecies)
            )
            breedAutoCompleteTextView.setAdapter(breedAdapter)
            breedAutoCompleteTextView.text = null
        }

        //Date Picker
        editTextDate = findViewById(R.id.etDate)
        binding.etDate.setOnClickListener {
            showDatePicker()
        }

        // Gender
        val genderAutoCompleteTextView: AutoCompleteTextView = findViewById(R.id.selectGender)
        val genderAdapter = ArrayAdapter(
            this,
            R.layout.dropdown_item,
            Gender.values().map { it.name }) // Provide a list of genders for the dropdown
        genderAutoCompleteTextView.setAdapter(genderAdapter) // Set the adapter to the AutoCompleteTextView

        // Add Pet Button
        binding.btnAddPet.setOnClickListener {
            petViewModel = ViewModelProvider(this)[PetViewModel::class.java]

            val species = binding.selectSpecies.text.toString()
            val breed = binding.selectBreed.text.toString()
            val dob = binding.etDate.text.toString()
            val name = binding.etName.text.toString()
            val gender = binding.selectGender.text.toString()

            // Use these variables for input checking
            val resultIntent = Intent().apply {
                putExtra("SPECIES", species)
                putExtra("BREED", breed)
                putExtra("DATE", dob)
                putExtra("NAME", name)
                putExtra("GENDER", gender)
            }
            setResult(RESULT_OK, resultIntent)

            insertDataToDatabase()
            }
    }

    private fun insertDataToDatabase() {
        val species = binding.selectSpecies.text.toString()
        val breed = binding.selectBreed.text.toString()
        val dob = binding.etDate.text.toString()
        val name = binding.etName.text.toString()
        val gender = binding.selectGender.text.toString()

        if (inputCheck(species, breed, dob, name, gender)) {
            // Create new pet
            val newPet = PetModel(0, species, breed, dob, name, gender)
            petViewModel.addPet(newPet)
            Toast.makeText(this, "Pet added!", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }


    private fun inputCheck(
        species: String,
        breed: String,
        dob: String,
        name: String,
        gender: String
    ): Boolean {
        return !(TextUtils.isEmpty(species) || TextUtils.isEmpty(breed) || TextUtils.isEmpty(dob) || TextUtils.isEmpty(name) || TextUtils.isEmpty(gender))
    }





    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { view: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            // Handle the date selected here
            calendar.set(year, month, dayOfMonth)
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val formattedDate = dateFormat.format(calendar.time)
            editTextDate.setText(formattedDate)
        }, year, month, day)

        // Set the maximum date to the current date
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis

        datePickerDialog.show()
    }






}








