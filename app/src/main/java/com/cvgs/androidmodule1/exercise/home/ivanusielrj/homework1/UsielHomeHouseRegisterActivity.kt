package com.cvgs.androidmodule1.exercise.home.ivanusielrj.homework1

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
import com.cvgs.androidmodule1.exercise.home.ivanusielrj.UsielHomeMainGralActivity

class UsielHomeHouseRegisterActivity : AppCompatActivity() {

    private lateinit var ibReturn : ImageButton
    private lateinit var btnRegisterHouse : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_home_house_register_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.visibility = View.VISIBLE

        btnRegisterHouse = findViewById(R.id.btnRegisterHouse)
        btnRegisterHouse.visibility = View.VISIBLE

        ibReturn.setOnClickListener {
            val secondScreen = Intent(this, UsielHomeMainGralActivity::class.java)
            startActivity(secondScreen)
        }

        btnRegisterHouse.setOnClickListener {
            val secondScreen = Intent(this, UsielHouseRegisterActivity::class.java)
            startActivity(secondScreen)
        }
    }
}