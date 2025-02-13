package com.cvgs.androidmodule1.exercise.home.salvadorchavez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.exercise.home.salvadorchavez.Exercise1.ChavaMenuExercise1Activity
import com.cvgs.androidmodule1.exercise.home.salvadorchavez.Exercise2.ChavaMenuExercise2Activity

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
            val intentEjercicio1 = Intent(this, ChavaMenuExercise1Activity::class.java)
            startActivity(intentEjercicio1)
        }

        btnEj2.setOnClickListener{
            val intentEjercicio2 = Intent(this, ChavaMenuExercise2Activity::class.java)
            startActivity(intentEjercicio2)
        }

        btnTarea.setOnClickListener{
            Toast.makeText(this,"Disponible el día de entrega", Toast.LENGTH_LONG).show()
        }

    }
}