package com.cvgs.androidmodule1.exercise.home.alexisescalona

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class AlexisSendParameters1Activity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == RESULT_OK) {
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT", false)

            if(isCorrect == true)
                Toast.makeText(this, "Is correct", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Is not correct", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, "CANCELLED:", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alexis_send_parameters1_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOpenSecondScreen = findViewById<Button>(R.id.btnOpenSecondScreen)

        btnOpenSecondScreen.setOnClickListener {
            val secondIntent = Intent(this, AlexisSendParameters2Activity::class.java).apply {
                putExtra("EXTRA_NAME", "Alexis Escalona Picazo")
                putExtra("EXTRA_MARRIED", false)
                putExtra("EXTRA_AGE", 28)
            }
            //startActivity(secondIntent)
            register.launch(secondIntent)
        }
    }
}