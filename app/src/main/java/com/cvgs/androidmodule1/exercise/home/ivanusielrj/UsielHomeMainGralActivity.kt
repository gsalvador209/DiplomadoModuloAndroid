package com.cvgs.androidmodule1.exercise.home.ivanusielrj

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
import com.cvgs.androidmodule1.exercise.home.GlobalHomeActivity
import com.cvgs.androidmodule1.exercise.home.ivanusielrj.exercise1.UsielHomeActivityHomework
import com.cvgs.androidmodule1.exercise.home.ivanusielrj.exercise2.UsielHomeMainActivityExerciseTwo
import com.cvgs.androidmodule1.exercise.home.ivanusielrj.homework1.UsielHomeHouseRegisterActivity

class UsielHomeMainGralActivity : AppCompatActivity() {

    private lateinit var btnFirstExercise: Button
    private lateinit var btnSecondExercise: Button
    private lateinit var btnHomework: Button
    private lateinit var ibReturn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_home_main_gral_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnFirstExercise = findViewById(R.id.btnFirstExercise)
        btnFirstExercise.visibility = View.VISIBLE

        btnSecondExercise = findViewById(R.id.btnSecondExercise)
        btnSecondExercise.visibility = View.VISIBLE

        btnHomework = findViewById(R.id.btnHomework)
        btnHomework.visibility = View.VISIBLE

        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.visibility = View.VISIBLE


        btnFirstExercise.setOnClickListener {
            val secondScreen = Intent(this, UsielHomeActivityHomework::class.java).apply {
            }
            startActivity(secondScreen)
        }

        btnSecondExercise.setOnClickListener {
            val secondScreen = Intent(this, UsielHomeMainActivityExerciseTwo::class.java).apply {
            }
            startActivity(secondScreen)
        }

        btnHomework.setOnClickListener {
            val secondScreen = Intent(this, UsielHomeHouseRegisterActivity::class.java).apply {
            }
            startActivity(secondScreen)
        }

        ibReturn.setOnClickListener {
            val secondScreen = Intent(this, GlobalHomeActivity::class.java)
            startActivity(secondScreen)
        }
    }
}