package com.cvgs.androidmodule1.exercise.home.alexisescalona.exercise1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class AlexisHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alexis_home_exercise_1_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOpenLifeCycleActivity = findViewById<Button>(R.id.btnLifeCycle)

        btnOpenLifeCycleActivity.setOnClickListener {
            val lifeCycleIntent = Intent(this, AlexisLifeCycleActivity::class.java)
            startActivity(lifeCycleIntent)
        }

        val btnOpenImplicitIntentActivity = findViewById<Button>(R.id.btnImplicitIntent)

        btnOpenImplicitIntentActivity.setOnClickListener {
            val implicitURLIntent = Intent(this, AlexisImplicitIntentActivity::class.java)
            startActivity(implicitURLIntent)
        }

        val btnOpenSendParametersActivity = findViewById<Button>(R.id.btnSendParameters)

        btnOpenSendParametersActivity.setOnClickListener {
            val sendParametersIntent = Intent(this, AlexisSendParameters1Activity::class.java)
            startActivity(sendParametersIntent)
        }
    }
}