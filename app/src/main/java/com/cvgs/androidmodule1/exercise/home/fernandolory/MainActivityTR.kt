package com.cvgs.androidmodule1.exercise.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cvgs.androidmodule1.R


class MainActivityTR : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tr)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellido = findViewById<EditText>(R.id.etApellido)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val rgSexo = findViewById<RadioGroup>(R.id.rgSexo)
        val etContrasena = findViewById<EditText>(R.id.etContrasena)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val correo = etCorreo.text.toString()
            val sexoId = rgSexo.checkedRadioButtonId
            val contrasena = etContrasena.text.toString()

            if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || sexoId == -1 || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val sexo = findViewById<RadioButton>(sexoId).text.toString()

                val intent = Intent(this, RegistroExitosoActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("apellido", apellido)
                intent.putExtra("correo", correo)
                intent.putExtra("sexo", sexo)
                intent.putExtra("contrasena", contrasena)
                startActivity(intent)
            }
        }
    }
}