package com.cvgs.androidmodule1.exercise.home.salvadorchavez.Exercise1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class ChavaFirstActivity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        //Register para cuando el usuario regrese a esta página
        //Info en result.resultCode y result.data
        if (result.resultCode == RESULT_OK){
            val isLegal = result.data?.getBooleanExtra("EXTRA_LEGAL_AGE",false)
            var tvLegal = findViewById<TextView>(R.id.tvChavaLegalAge)
            if (isLegal == true){
                tvLegal.text = "Eres mayor de edad"
            }else {
                tvLegal.text = ""
            }
            //Toast.makeText(this,"isCorrect: $isCorrect", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Accion cancelada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chava_first_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSegundaAct = findViewById<Button>(R.id.btnChavaToSecond)
        val edName = findViewById<EditText>(R.id.etChavaName)
        val dpBirthday = findViewById<DatePicker>(R.id.datePickerChava)


        btnSegundaAct.setOnClickListener{
            val name = edName.text.toString()
            val day = dpBirthday.dayOfMonth
            val month = dpBirthday.month
            val year = dpBirthday.year
            //Toast.makeText(this,name,Toast.LENGTH_LONG).show()
            val secondScreen = Intent(this, ChavaSecondActivity::class.java).apply{
                putExtra("EXTRA_NAME",name)
                putExtra("EXTRA_DAY",day)
                putExtra("EXTRA_MONTH",month)
                putExtra("EXTRA_YEAR",year)
            }
            //startActivity(secondIntent)
            register.launch(secondScreen)
        }

    }
}