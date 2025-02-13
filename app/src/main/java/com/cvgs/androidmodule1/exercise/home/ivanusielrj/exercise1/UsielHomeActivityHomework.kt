package com.cvgs.androidmodule1.exercise.home.ivanusielrj.exercise1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class UsielHomeActivityHomework : AppCompatActivity() {

    private lateinit var btnCicleLife: Button
    private lateinit var btnLink: Button
    private lateinit var btnReturnInfo: Button
    private lateinit var btnReturn: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_home_homework_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCicleLife = findViewById(R.id.btnCicleLife)
        btnCicleLife.visibility = View.VISIBLE

        btnLink = findViewById(R.id.btnLink)
        btnLink.visibility = View.VISIBLE

        btnReturnInfo = findViewById(R.id.btnReturnInfo)
        btnReturnInfo.visibility = View.VISIBLE

        btnReturn = findViewById(R.id.btnReturn)
        btnReturn.visibility = View.VISIBLE

        btnCicleLife.setOnClickListener {
            val secondScreen = Intent(this, UsielLifeCicleActivityHomework::class.java).apply {
            }
            startActivity(secondScreen)
        }

        btnLink.setOnClickListener {
            val secondScreen = Intent(this, UsielLinkButtonActvityHomework::class.java).apply {
            }
            startActivity(secondScreen)
        }

        btnReturnInfo.setOnClickListener {
            val secondScreen = Intent(this, UsielCallActivityHomework::class.java).apply {
            }
            startActivity(secondScreen)
        }

        btnReturn.setOnClickListener {
            finish()
        }
    }
}