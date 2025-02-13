package com.cvgs.androidmodule1.exercise.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R

class ListaMascotasActivity : AppCompatActivity() {

    //Lista de mascotas
    companion object{
   val listaMascotas = mutableListOf<Mascota>()
    } //mantiene la lista
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lista_mascotas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Referencia al RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMascotas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Verificar si se recibió una nueva mascota desde RegistrarMascotaActivity
        val nuevaMascota = intent.getSerializableExtra("nueva_mascota")as? Mascota
        if (nuevaMascota != null){
            listaMascotas.add(nuevaMascota)//Agregar la nueva mascota a la lista
        }

        // Adaptador del RecycleView
        val adapter = MascotaAdapter(listaMascotas)
        recyclerView.adapter = adapter

        val btnNuevaMascota = findViewById<Button>(R.id.btnNuevaMascota)
        btnNuevaMascota.setOnClickListener {
            val intent = Intent(this, RegistrarMascotaActivity::class.java)
            startActivity(intent) //Ir a la pantalla de registro
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent (this, MainActivityFer::class.java)
        startActivity(intent)
        finish()
    }
}