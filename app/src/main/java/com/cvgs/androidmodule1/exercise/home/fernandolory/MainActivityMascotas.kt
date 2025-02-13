package com.cvgs.androidmodule1.exercise.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class MainActivityMascotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_mascota)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        // Referencias a los botones de layout
        val btnRegistrarMascota = findViewById<Button>(R.id.btnRegistrarMascota)
        val btnVerMascotas = findViewById<Button>(R.id.btnVerMascotas)

        // Acción para el botón de "Registrar Mascota"
        btnRegistrarMascota.setOnClickListener {
            val intent = Intent(this, RegistrarMascotaActivity::class.java)
            startActivity(intent) //Navegar a la pantalla de registro
        }
        // Accion para  el botón de "Ver Mascotas Registradas"
        btnVerMascotas.setOnClickListener {
            val intent = Intent(this, ListaMascotasActivity::class.java)
            startActivity(intent)  //Navegar a la pantalla de lista de mascotas
        }

    }
}