package com.cvgs.androidmodule1.exercise.home.alexisescalona.exercise2.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R

class AlexisRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alexis_recycler_view_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvAnimal = findViewById<RecyclerView>(R.id.rvAnimal)

        val data = listOf(AnimalEntity("Leon", "Amarillo", ""),
            AnimalEntity("Perro", "Café", ""),
            AnimalEntity("Gato", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
            AnimalEntity("Jirafa", "Amarillo", ""),
        )

        val adapter = AnimalAdapter(data)
        rvAnimal.adapter = adapter
        rvAnimal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}