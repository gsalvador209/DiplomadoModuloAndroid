package com.cvgs.androidmodule1.exercise.home.alexisescalona.homework1

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class AlexisRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alexis_registration_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener{
            var isDataCorrect = true
            if(etFirstName.text.isEmpty()) {
                isDataCorrect = false
                Toast.makeText(this, "First name cannot be empty", Toast.LENGTH_SHORT).show()
            }
            if(etLastName.text.isEmpty()){
                isDataCorrect = false
                Toast.makeText(this, "Last name cannot be empty", Toast.LENGTH_SHORT).show()
            }
            if(etEmail.text.isEmpty()){
                isDataCorrect = false
                Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show()
            }else if(!Patterns.EMAIL_ADDRESS.matcher(etEmail.text).matches()){
                isDataCorrect = false
                Toast.makeText(this, "Email is not valid", Toast.LENGTH_SHORT).show()
            }
            if(rgSex.checkedRadioButtonId == -1){
                isDataCorrect = false
                Toast.makeText(this, "Sex cannot be empty", Toast.LENGTH_SHORT).show()
            }
            if(etPassword.text.isEmpty()){
                isDataCorrect = false
                Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show()
            }

            if(isDataCorrect) {
                val registrationSuccessIntent =
                    Intent(this, AlexisRegistrationSuccessActivity::class.java).apply {
                        putExtra("EXTRA_FIRSTNAME", etFirstName.text.toString())
                        putExtra("EXTRA_LASTNAME", etLastName.text.toString())
                        putExtra("EXTRA_EMAIL", etEmail.text.toString())
                        putExtra("EXTRA_SEX", findViewById<RadioButton>(rgSex.checkedRadioButtonId).text.toString())
                        putExtra("EXTRA_PASSWORD", etPassword.text.toString())
                    }
                startActivity(registrationSuccessIntent)
            }
        }
    }
}