package com.cvgs.androidmodule1.exercise.classroom.graphiccomponent.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R

class ChavaRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*****************************************
                    Variables
         ****************************************/
        val rvAnimal = findViewById<RecyclerView>(R.id.rvAnimal) // Lista

        val data = listOf(AnimalEntity("Lion","Yellow",""), //Lista de elementos
            AnimalEntity("Dog","Black",""),
            AnimalEntity("Cat", "Black",""),
            AnimalEntity("Racoon", "Gray",""),
            AnimalEntity("Bird", "Green",""),
            AnimalEntity("Snake","Brown",""),
            AnimalEntity("Snake","Brown",""),
            AnimalEntity("Snake","Brown",""),
            AnimalEntity("Snake","Brown",""),
            AnimalEntity("Snake","Brown",""),
            AnimalEntity("Snake","Brown","")
        )

        val adapter = AnimalAdapter(data)
        rvAnimal.adapter = adapter
        rvAnimal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
    }

}