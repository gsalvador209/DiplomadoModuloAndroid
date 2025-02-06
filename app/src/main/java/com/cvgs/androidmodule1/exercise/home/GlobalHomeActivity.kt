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
import com.cvgs.androidmodule1.exercise.home.salvadorchavez.ChavaMenuActivity

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

        val btnOpenAlexisHomeActivity = findViewById<Button>(R.id.btnAlexis)
        val btnOpenUsielHomeActivity = findViewById<Button>(R.id.btnUsiel)
        val btnOpenSalvadorHomeActivity = findViewById<Button>(R.id.btnSalvador)

        btnOpenAlexisHomeActivity.setOnClickListener {
            val alexisHomeIntent = Intent(this, AlexisHomeActivity::class.java)
            startActivity(alexisHomeIntent)
        }

        btnOpenUsielHomeActivity.setOnClickListener {
            val usielisHomeIntent = Intent(this, UsielHomeActivityHomework::class.java)
            startActivity(usielisHomeIntent)
        }

        btnOpenSalvadorHomeActivity.setOnClickListener{
            val salvadorHomeIntent = Intent(this, ChavaMenuActivity::class.java)
            startActivity(salvadorHomeIntent)
        }
    }
}