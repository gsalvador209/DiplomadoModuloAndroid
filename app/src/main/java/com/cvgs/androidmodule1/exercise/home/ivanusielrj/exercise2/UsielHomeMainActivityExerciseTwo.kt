package com.cvgs.androidmodule1.exercise.home.ivanusielrj.exercise2

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
import com.cvgs.androidmodule1.exercise.home.ivanusielrj.exercise2.usielrecyclerview.UsielRecyclerviewActivity

class UsielHomeMainActivityExerciseTwo : AppCompatActivity() {

    private lateinit var btnFrameLayout : Button
    private lateinit var btnLinearLayout : Button
    private lateinit var btnRelativeLayout : Button
    private lateinit var btnConstrainLayout : Button
    private lateinit var btnReciclerView : Button
    private lateinit var btnComponent : Button
    private lateinit var ibReturn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_home_main_exercise_two_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnFrameLayout = findViewById(R.id.btnFrameLayout)
        btnFrameLayout.visibility = View.VISIBLE

        btnLinearLayout = findViewById(R.id.btnLinearLayout)
        btnLinearLayout.visibility = View.VISIBLE

        btnRelativeLayout = findViewById(R.id.btnRelativeLayout)
        btnRelativeLayout.visibility = View.VISIBLE

        btnConstrainLayout = findViewById(R.id.btnConstrainLayout)
        btnConstrainLayout.visibility = View.VISIBLE

        btnReciclerView = findViewById(R.id.btnReciclerView)
        btnReciclerView.visibility = View.VISIBLE

        btnComponent = findViewById(R.id.btnComponent)
        btnComponent.visibility = View.VISIBLE

        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.visibility = View.VISIBLE

        btnFrameLayout.setOnClickListener {
            val secondScreen = Intent(this, UsielFrameLayaoutActivity::class.java).apply {
            }
            startActivity(secondScreen)
        }

        btnLinearLayout.setOnClickListener {
            val secondScreen = Intent(this, UsielLinearLayoutActivity::class.java).apply {
            }
            startActivity(secondScreen)
        }

        btnRelativeLayout.setOnClickListener {
            val secondScreen = Intent(this, UsielRelativeLayoutActivity::class.java).apply {
            }
            startActivity(secondScreen)
        }

        btnConstrainLayout.setOnClickListener {
            val secondScreen = Intent(this, UsielConstrainLayoutActivity::class.java).apply {
            }
            startActivity(secondScreen)
        }

        btnReciclerView.setOnClickListener {
            val secondScreen = Intent(this, UsielRecyclerviewActivity::class.java).apply {
            }
            startActivity(secondScreen)
        }

        btnComponent.setOnClickListener {
            val secondScreen = Intent(this, UsielComponentActivity::class.java).apply {
            }
            startActivity(secondScreen)
        }

        ibReturn.setOnClickListener {
            finish()
        }
    }
}