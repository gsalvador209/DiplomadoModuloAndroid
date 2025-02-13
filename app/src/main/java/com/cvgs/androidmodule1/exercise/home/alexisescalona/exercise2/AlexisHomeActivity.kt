package com.cvgs.androidmodule1.exercise.home.alexisescalona.exercise2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.exercise.home.alexisescalona.exercise2.recyclerview.AlexisRecyclerViewActivity

class AlexisHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alexis_home_exercise_2_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOpenFrameLayoutActivity = findViewById<Button>(R.id.btnFrameLayout)

        btnOpenFrameLayoutActivity.setOnClickListener {
            val frameLayoutIntent = Intent(this, AlexisFrameLayoutActivity::class.java)
            startActivity(frameLayoutIntent)
        }

        val btnOpenLinearLayoutActivity = findViewById<Button>(R.id.btnLinearLayout)

        btnOpenLinearLayoutActivity.setOnClickListener {
            val linearlayoutIntent = Intent(this, AlexisLinearLayoutActivity::class.java)
            startActivity(linearlayoutIntent)
        }

        val btnOpenRelativeLayoutActivity = findViewById<Button>(R.id.btnRelativeLayout)

        btnOpenRelativeLayoutActivity.setOnClickListener {
            val relativeLayoutIntent = Intent(this, AlexisRelativeLayoutActivity::class.java)
            startActivity(relativeLayoutIntent)
        }

        val btnOpenConstraintLayoutActivity = findViewById<Button>(R.id.btnConstraintLayout)

        btnOpenConstraintLayoutActivity.setOnClickListener {
            val constraintLayoutActivity = Intent(this, AlexisConstraintLayoutActivity::class.java)
            startActivity(constraintLayoutActivity)
        }

        val btnOpenComponentsActivity = findViewById<Button>(R.id.btnComponents)

        btnOpenComponentsActivity.setOnClickListener {
            val componentsActivity = Intent(this, AlexisComponentsActivity::class.java)
            startActivity(componentsActivity)
        }

        val btnOpenRecyclerViewActivity = findViewById<Button>(R.id.btnRecyclerView)

        btnOpenRecyclerViewActivity.setOnClickListener {
            val recyclerViewActivity = Intent(this, AlexisRecyclerViewActivity::class.java)
            startActivity(recyclerViewActivity)
        }
    }
}