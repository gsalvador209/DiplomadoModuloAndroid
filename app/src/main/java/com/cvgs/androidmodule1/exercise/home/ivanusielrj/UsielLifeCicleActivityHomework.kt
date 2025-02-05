package com.cvgs.androidmodule1.exercise.home.ivanusielrj

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class UsielLifeCicleActivityHomework : AppCompatActivity() {

    private lateinit var btnReturn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_life_cicle_homework_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnReturn = findViewById(R.id.btnReturn)
        btnReturn.visibility = View.VISIBLE

        btnReturn.setOnClickListener {
            Toast.makeText(this, "Coming Back Home", Toast.LENGTH_SHORT).show()
            finish()
        }

        updateCicle("onCreate")

    }

    override fun onStart() {
        super.onStart()
        val state = "onStart"
        updateCicle(state)
    }

    override fun onResume() {
        super.onResume()
        val state = "onResume"
        updateCicle(state)
    }

    override fun onPause() {
        super.onPause()
        val state = "onPause"
        updateCicle(state)
    }

    override fun onStop() {
        super.onStop()
        val state = "onStop"
        updateCicle(state)
    }

    override fun onDestroy() {
        super.onDestroy()
        val state = "onDestroy"
        updateCicle(state)
    }

    override fun onRestart() {
        super.onRestart()
        val state = "onRestart"
        updateCicle(state)
    }

    private fun updateCicle(state: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Estado por el que pasó el Ciclo de Vida")
            .setMessage("State: $state")
            .setPositiveButton("Ok") { dialog, which ->
            }.show()
        Toast.makeText(this, "State $state", Toast.LENGTH_SHORT).show()

    }
}