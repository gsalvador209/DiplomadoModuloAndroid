package com.cvgs.androidmodule1.exercise.home.salvadorchavez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
//import com.cvgs.androidmodule1.exercise.classroom.graphiccomponent.recyclerview.RecyclerViewActivity
//import com.cvgs.androidmodule1.exercise.home.salvadorchavez.exercise1.ChavaFirstHomeworkActivity

class ChavaModuleMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chava_module_menu_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*val btnClass = findViewById<Button>(R.id.btnChavaClassroom)
        val btnHome = findViewById<Button>(R.id.btnChavaHome)


        btnHome.setOnClickListener{
            val menuTareas = Intent(this, ChavaFirstHomeworkActivity::class.java)
            startActivity(menuTareas)
        }

        btnClass.setOnClickListener{
            val menuHomework = Intent(this, RecyclerViewActivity::class.java)
            startActivity(menuHomework)
        }*/

    }
}