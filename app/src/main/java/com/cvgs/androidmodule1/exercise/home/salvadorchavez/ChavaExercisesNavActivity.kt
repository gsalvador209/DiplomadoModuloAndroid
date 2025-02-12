package com.cvgs.androidmodule1.exercise.home.salvadorchavez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class ChavaExercisesNavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chava_exercises_nav)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnEj1 = findViewById<Button>(R.id.btnEj1)
        val btnEj2 = findViewById<Button>(R.id.btnEj2)
        val btnTarea = findViewById<Button>(R.id.btnTarea)

        btnEj1.setOnClickListener{
            val ejercicio1Intent = Intent(this, ChavaMenuActivity::class.java)
            startActivity(ejercicio1Intent)
        }

    }
}