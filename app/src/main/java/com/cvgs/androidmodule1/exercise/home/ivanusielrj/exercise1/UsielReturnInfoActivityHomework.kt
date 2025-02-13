package com.cvgs.androidmodule1.exercise.home.ivanusielrj.exercise1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class UsielReturnInfoActivityHomework : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvAge: TextView
    private lateinit var tvGen: TextView
    private lateinit var btnReturn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_return_info_homework_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvName = findViewById(R.id.tvName)
        tvName.visibility = View.VISIBLE

        tvAge = findViewById(R.id.tvAge)
        tvAge.visibility = View.VISIBLE

        tvGen = findViewById(R.id.tvGen)
        tvGen.visibility = View.VISIBLE

        btnReturn = findViewById(R.id.btnReturn)
        btnReturn.visibility = View.VISIBLE

        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME")) {
                val name = it.getString("EXTRA_NAME")
                tvName.text = name
            }

            if (it.containsKey("EXTRA_AGE")) {
                val age = it.getInt("EXTRA_AGE", 0)
                tvAge.text = age.toString()
            }

            if (it.containsKey("EXTRA_GEN")) {
                val gen = it.getString("EXTRA_GEN")
                tvGen.text = gen
            }
        }

        btnReturn.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("EXTRA_IS_CORRECT", true)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }

    }
}