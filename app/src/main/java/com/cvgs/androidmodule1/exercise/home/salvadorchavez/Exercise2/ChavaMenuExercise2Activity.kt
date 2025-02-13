package com.cvgs.androidmodule1.exercise.home.salvadorchavez.Exercise2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.exercise.home.salvadorchavez.Exercise2.recyclerview.ChavaRecyclerViewActivity


class ChavaMenuExercise2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chava_menu_exercise2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnLinear = findViewById<Button>(R.id.btnLinearLayout)
        val btnRelative = findViewById<Button>(R.id.btnRelativeLayout)
        val btnConstraint = findViewById<Button>(R.id.btnConstraintLayout)
        val btnRecycler = findViewById<Button>(R.id.btnRecyclerView)
        val btnComponents = findViewById<Button>(R.id.btnComponents)

        btnLinear.setOnClickListener{
            val intentLinear = Intent(this, ChavaLinearLayoutActivity::class.java)
            startActivity(intentLinear)
        }

        btnRelative.setOnClickListener{
            val intentRelative = Intent(this, ChavaRelativeLayout::class.java)
            startActivity(intentRelative)
        }

        btnComponents.setOnClickListener{
            val intentComponents = Intent(this, ChavaComponentActivity::class.java)
            startActivity(intentComponents)
        }

        btnConstraint.setOnClickListener{
            val intentConstraint = Intent(this, ChavaConstrainLayoutActivity::class.java)
            startActivity(intentConstraint)
        }

        btnRecycler.setOnClickListener{
            val intentRecycler = Intent(this, ChavaRecyclerViewActivity::class.java)
            startActivity(intentRecycler)
        }

    }
}