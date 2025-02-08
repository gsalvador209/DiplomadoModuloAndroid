package com.cvgs.androidmodule1.exercise.home.salvadorchavez.excercise1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import java.util.Calendar

class ChavaSecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chava_second_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName = findViewById<TextView>(R.id.tvChavaName)
        val tvAge = findViewById<TextView>(R.id.tvChavaAge)
        val btnChavaToFirst = findViewById<Button>(R.id.btnChavaToFirst)

        //Al parecer, tengo que usar Calendar para API menores a 26
        //Si se trabajara con API 26+ se usaría LocalDate
        val dob = Calendar.getInstance() //Para el cumpleaños
        val today = Calendar.getInstance() //Para el día de hoy

        var boolLegalAge = false

        //Lectura de intents en el Bundle
        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME")) { //it es intent.extras
                val name = it.getString("EXTRA_NAME")
                //Toast.makeText(this,name,Toast.LENGTH_LONG).show()
                tvName.text = "Hola, $name"
            }
            if (it.containsKey("EXTRA_YEAR") && it.containsKey("EXTRA_MONTH") && it.containsKey("EXTRA_DAY")) {
                val year = it.getInt("EXTRA_YEAR")
                val month = it.getInt("EXTRA_MONTH")
                val day = it.getInt("EXTRA_DAY")

                //Configura el calendario dob de acuerdo a la información de la actividad anterior
                dob.set(year,month-1,day)


                var age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
                if(today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                    age--
                }


                tvAge.text = "Tienes $age años"

                if (age > 18) {
                    boolLegalAge = true
                }
            }

        }

        btnChavaToFirst.setOnClickListener{
            val firstActivity = Intent().apply {
                putExtra("EXTRA_IS_CORRECT",true)
                putExtra("EXTRA_LEGAL_AGE", boolLegalAge)
            }
            setResult(RESULT_OK,firstActivity)
            finish() //Se finaliza esta actividad
        }
    }
}