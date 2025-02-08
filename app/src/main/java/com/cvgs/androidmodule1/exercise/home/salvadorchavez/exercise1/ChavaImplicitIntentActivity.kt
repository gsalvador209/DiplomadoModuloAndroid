package com.cvgs.androidmodule1.exercise.home.salvadorchavez.excercise1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class ChavaImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chava_implicit_intent_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOpenURL = findViewById<Button>(R.id.btnChavaURL)

        btnOpenURL.setOnClickListener{
            val openUrlIntent = Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/gsalvador209"))
            startActivity(Intent.createChooser(openUrlIntent,"Selecciona un navegador"))
        }

    }
}