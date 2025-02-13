package com.cvgs.androidmodule1.exercise.home.alexisescalona

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.exercise.home.alexisescalona.homework1.AlexisRegistrationActivity
import com.cvgs.androidmodule1.exercise.home.alexisescalona.exercise1.AlexisHomeActivity as HomeExercise1
import com.cvgs.androidmodule1.exercise.home.alexisescalona.exercise2.AlexisHomeActivity as HomeExercise2

class AlexisHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alexis_home_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOpenExercise1HomeActivity = findViewById<Button>(R.id.btnExercise1)

        btnOpenExercise1HomeActivity.setOnClickListener {
            val exercise1HomeIntent = Intent(this, HomeExercise1::class.java)
            startActivity(exercise1HomeIntent)
        }

        val btnOpenExercise2HomeActivity = findViewById<Button>(R.id.btnExercise2)

        btnOpenExercise2HomeActivity.setOnClickListener {
            val implicitURLIntent = Intent(this, HomeExercise2::class.java)
            startActivity(implicitURLIntent)
        }

        val btnOpenHomeWork1Activity = findViewById<Button>(R.id.btnHomework1)

        btnOpenHomeWork1Activity.setOnClickListener {
            val sendParametersIntent = Intent(this, AlexisRegistrationActivity::class.java)
            startActivity(sendParametersIntent)
        }
    }
}