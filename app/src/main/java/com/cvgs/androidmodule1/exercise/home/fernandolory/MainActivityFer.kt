package com.cvgs.androidmodule1.exercise.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class MainActivityFer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_fer)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnTareaRegistroApp = findViewById<Button>(R.id.btnTareaRegistroApp)

        btnTareaRegistroApp.setOnClickListener {
            val intent = Intent(this, MainActivityTR::class.java)
            startActivity(intent)
        }
        val btnEjercicio2 = findViewById<Button>(R.id.btnEjercicio2Componentes)

        btnEjercicio2.setOnClickListener {
            val intent = Intent(this, MainActivityMascotas::class.java)
            startActivity(intent)
        }
    }


}