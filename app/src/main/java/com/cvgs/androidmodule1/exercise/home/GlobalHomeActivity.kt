package com.cvgs.androidmodule1.exercise.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.exercise.home.alexisescalona.AlexisHomeActivity
import com.cvgs.androidmodule1.exercise.home.ivanusielrj.UsielHomeActivityHomework

class GlobalHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_global_home_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOpenAlexisHomeActivity = findViewById<Button>(R.id.bntAlexis)

        btnOpenAlexisHomeActivity.setOnClickListener {
            val alexisHomeIntent = Intent(this, AlexisHomeActivity::class.java)
            startActivity(alexisHomeIntent)
        }

        val btnOpenUsielHomeActivity = findViewById<Button>(R.id.bntUsiel)

        btnOpenUsielHomeActivity.setOnClickListener {
            val usielisHomeIntent = Intent(this, UsielHomeActivityHomework::class.java)
            startActivity(usielisHomeIntent)
        }
    }
}