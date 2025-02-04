package com.cvgs.androidmodule1.exercise.home.alexisescalona

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class AlexisSendParameters2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alexis_send_parameters2_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvIsMarried = findViewById<TextView>(R.id.tvIsMarried)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val btnReturnInfo = findViewById<Button>(R.id.btnReturnInfo)

        intent.extras?.let {
            if(it.containsKey("EXTRA_NAME")){
                val name = it.getString("EXTRA_NAME")
                //Toast.makeText(this, "Nombre $name", Toast.LENGTH_LONG).show()
                tvName.text = name
            }
            if(it.containsKey("EXTRA_MARRIED")){
                val isMarried = it.getBoolean("EXTRA_MARRIED")
                //Toast.makeText(this, "Eres casado? ${if(isMarried) "si" else "no"}", Toast.LENGTH_LONG).show()
                tvIsMarried.text = if(isMarried) {
                    "Married"
                }
                else {
                    "Not Married"
                }
            }
            if(it.containsKey("EXTRA_AGE")){
                val age = it.getInt("EXTRA_AGE")
                //Toast.makeText(this, "Tu edad es de $age años", Toast.LENGTH_LONG).show()
                tvAge.text = age.toString()
            }
        }

        btnReturnInfo.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("EXTRA_IS_CORRECT", true)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}