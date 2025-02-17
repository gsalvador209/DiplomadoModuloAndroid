package com.cvgs.androidmodule1.exercise.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.exercise.home.alexisescalona.AlexisHomeActivity
import com.cvgs.androidmodule1.exercise.home.ivanusielrj.UsielHomeMainGralActivity
import com.cvgs.androidmodule1.exercise.home.salvadorchavez.ChavaExercisesNavActivity
import com.cvgs.androidmodule1.finalexercise.FinalExerciseMainActivity
import com.squareup.picasso.Picasso

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

        val ivMain = findViewById<ImageView>(R.id.ivMain)
        val btnOpenFinalExerciseActivity = findViewById<Button>(R.id.btnFinalExercise)
        val btnOpenAlexisHomeActivity = findViewById<Button>(R.id.btnAlexis)
        val btnOpenUsielHomeActivity = findViewById<Button>(R.id.btnUsiel)
        val btnOpenSalvadorHomeActivity = findViewById<Button>(R.id.btnSalvador)
        val btnOpenFernandoHomeActivity = findViewById<Button>(R.id.btnFer)

        Picasso.get()
            .load("https://i.postimg.cc/3RHn9LgQ/Equipo-4.png")
            .placeholder(R.drawable.img_btn_home)
            .error(R.drawable.ic_android_black_24dp)
            .into(ivMain);

        btnOpenFinalExerciseActivity.setOnClickListener {
            val finalExerciseIntent = Intent(this, FinalExerciseMainActivity::class.java)
            startActivity(finalExerciseIntent)
        }

        btnOpenAlexisHomeActivity.setOnClickListener {
            val alexisHomeIntent = Intent(this, AlexisHomeActivity::class.java)
            startActivity(alexisHomeIntent)
        }

        btnOpenUsielHomeActivity.setOnClickListener {
            val usielisHomeIntent = Intent(this, UsielHomeMainGralActivity::class.java)
            startActivity(usielisHomeIntent)
        }

        btnOpenSalvadorHomeActivity.setOnClickListener{
            val salvadorHomeIntent = Intent(this, ChavaExercisesNavActivity::class.java)
            startActivity(salvadorHomeIntent)
        }

        btnOpenFernandoHomeActivity.setOnClickListener {
            Toast.makeText(this, "se le dio clic", Toast.LENGTH_SHORT).show()
            val fernandoHomeIntent = Intent(this, MainActivityFer::class.java)
            startActivity(fernandoHomeIntent)
        }
    }
}