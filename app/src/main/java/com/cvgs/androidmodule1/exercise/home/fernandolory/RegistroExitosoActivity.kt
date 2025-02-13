package com.cvgs.androidmodule1.exercise.home

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cvgs.androidmodule1.R


class RegistroExitosoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_exitoso)

        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvApellido = findViewById<TextView>(R.id.tvApellido)
        val tvCorreo = findViewById<TextView>(R.id.tvCorreo)
        val tvSexo = findViewById<TextView>(R.id.tvSexo)
        val tvContrasena = findViewById<TextView>(R.id.tvContrasena)

        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val correo = intent.getStringExtra("correo")
        val sexo = intent.getStringExtra("sexo")
        val contrasena = intent.getStringExtra("contrasena")

        tvNombre.text = "Nombre: $nombre"
        tvApellido.text = "Apellido: $apellido"
        tvCorreo.text = "Correo: $correo"
        tvSexo.text = "Sexo: $sexo"
        tvContrasena.text = "Contraseña: $contrasena"
    }
}