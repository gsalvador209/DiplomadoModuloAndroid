package com.cvgs.androidmodule1.exercise.home.ivanusielrj.exercise2

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class UsielConstrainLayoutActivity : AppCompatActivity() {

    private lateinit var ibReturn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_constrain_layout_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.visibility = View.VISIBLE

        ibReturn.setOnClickListener {
            finish()
        }
    }
}