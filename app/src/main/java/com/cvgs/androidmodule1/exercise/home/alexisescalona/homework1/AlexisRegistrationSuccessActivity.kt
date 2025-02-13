package com.cvgs.androidmodule1.exercise.home.alexisescalona.homework1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class AlexisRegistrationSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alexis_registration_success_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvFirstName = findViewById<TextView>(R.id.tvFirstName)
        val tvLastName = findViewById<TextView>(R.id.tvLastName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvSex = findViewById<TextView>(R.id.tvSex)
        val tvPassword = findViewById<TextView>(R.id.tvPassword)

        val bundle = intent.extras
        tvFirstName.text = bundle?.getString("EXTRA_FIRSTNAME")
        tvLastName.text = bundle?.getString("EXTRA_LASTNAME")
        tvEmail.text = bundle?.getString("EXTRA_EMAIL")
        tvSex.text = bundle?.getString("EXTRA_SEX")
        tvPassword.text = bundle?.getString("EXTRA_PASSWORD")
    }
}