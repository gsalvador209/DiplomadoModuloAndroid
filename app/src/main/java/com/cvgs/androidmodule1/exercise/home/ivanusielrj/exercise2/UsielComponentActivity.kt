package com.cvgs.androidmodule1.exercise.home.ivanusielrj.exercise2

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class UsielComponentActivity : AppCompatActivity() {

    private lateinit var etName : EditText
    private lateinit var etAge : EditText
    private lateinit var rbGroup : RadioGroup
    private lateinit var cbCreditCard : CheckBox
    private lateinit var spFrom : Spinner
    private lateinit var btSubmit : Button
    private lateinit var ibReturn : ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_component_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initView()

        val countries = listOf("México", "Argentina", "Colombia", "España", "Ecuador")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        spFrom.adapter = adapter

        btSubmit.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString()
            val selectedGen = getGenFromRadioGroup(rbGroup.checkedRadioButtonId, true)
            val hasCreditCard = cbCreditCard.isChecked
            val selectedCountry = spFrom.selectedItem.toString()

            if (age.isEmpty() || selectedGen == null) {
                Toast.makeText(this, "Por favor complete el cuestionario", Toast.LENGTH_SHORT).show()
            } else {
                showAlert(name, age, selectedGen, hasCreditCard, selectedCountry)
            }
        }

        ibReturn.setOnClickListener {
            finish()
        }
    }

    private fun initView() {
        etName = findViewById(R.id.etName)
        etName.visibility = View.VISIBLE

        etAge = findViewById(R.id.etAge)
        etAge.visibility = View.VISIBLE

        rbGroup = findViewById(R.id.rbGroup)
        rbGroup.visibility = View.VISIBLE

        cbCreditCard = findViewById(R.id.cbCreditCard)
        cbCreditCard.visibility = View.VISIBLE

        spFrom = findViewById(R.id.spFrom)
        spFrom.visibility = View.VISIBLE

        btSubmit = findViewById(R.id.btSubmit)
        btSubmit.visibility = View.VISIBLE

        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.visibility = View.VISIBLE

    }

    private fun getGenFromRadioGroup(checkedId: Int, isFromButton: Boolean): String {
        return when(checkedId){
            R.id.rbWomen ->{
                if(isFromButton) "Mujer" else "Mujer"
            }
            R.id.rbMen ->{
                if (isFromButton) "Hombre" else "Hombre"
            }
            else -> "Desconocido"
        }

    }

    private fun showAlert(name: String, age: String, gen: String, hasCreditCard: Boolean, country: String) {
        val message = """
            Nombre: $name
            Edad: $age
            Género: $gen
            ¿Tiene tarjeta de crédito? ${if (hasCreditCard) "Sí" else "No"}
            País: $country
        """.trimIndent()

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Tus Respuestas fueron:")
            .setMessage(message)
            .setPositiveButton("Aceptar") { dialog, which ->
                Toast.makeText(this, "Gracias tu solicitud ha sido enviada", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancelar", null)
            .create()
        alertDialog.show()
    }
}