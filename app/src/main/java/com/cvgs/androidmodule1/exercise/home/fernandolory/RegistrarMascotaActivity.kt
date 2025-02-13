package com.cvgs.androidmodule1.exercise.home

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class RegistrarMascotaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registrar_mascota)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Referencias  a los elementos de la interfaz
        val etNombreMascota =findViewById<EditText>(R.id.etNombreMascota)
        val spinnerEspecie = findViewById<Spinner>(R.id.spinnerEspecie)
        val etRazaMascota = findViewById<EditText>(R.id.etRazaMascota)
        val rgSexo =findViewById<RadioGroup>(R.id.rgSexo)
        val etEdadMascota = findViewById<EditText>(R.id.etEdadMascota)
        val btnGuardarMascota = findViewById<Button>(R.id.btnGuardarMascota)

        //Opciones del Spinner (Especie)
        val especies = arrayOf ("Perro", "Gato", "Otro")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, especies )
        spinnerEspecie.adapter = adapter

        // Acción del botón Guardar Mascota
        btnGuardarMascota.setOnClickListener {
            val nombre = etNombreMascota.text.toString()
            val especie = spinnerEspecie.selectedItem.toString()
            val raza = etRazaMascota.text.toString()
            val sexoId =rgSexo.checkedRadioButtonId
            val sexo = findViewById<RadioButton>(sexoId)?.text.toString()
            val edad = etEdadMascota.text.toString()

            if (nombre.isNotEmpty() && raza.isNotEmpty() && sexo.isNotEmpty() && edad.isNotEmpty()){
                val mascota = Mascota(nombre, especie, raza, "$edad años")
                val intent = Intent(this, ListaMascotasActivity::class.java)
                intent.putExtra("nueva_mascota", mascota)  // Enviar el objeto Mascota
                startActivity(intent)                      //  Esto inicia la actividad

            } else {
                Toast.makeText(this, "Por favor completa los campos", Toast.LENGTH_LONG).show()
            }
        }

    }
}