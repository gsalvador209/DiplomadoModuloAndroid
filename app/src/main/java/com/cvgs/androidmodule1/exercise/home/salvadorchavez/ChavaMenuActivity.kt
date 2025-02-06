package com.cvgs.androidmodule1.exercise.home.salvadorchavez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.exercise.classroom.explicitintent.SecondScreenActivity

class ActivitiesMenu : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_activities_menu_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnActividad1 = findViewById<Button>(R.id.btnChavaLifeCycle)

        btnActividad1.setOnClickListener{
            val lifeCicleIntent = Intent(this, SecondScreenActivity::class.java)
            register.launch(lifeCicleIntent)

        }

    }
}