<<<<<<<< HEAD:app/src/main/java/com/cvgs/androidmodule1/exercise/home/salvadorchavez/Exercise1/ChavaMenuExercise1Activity.kt
package com.cvgs.androidmodule1.exercise.home.salvadorchavez.Exercise1
========
package com.cvgs.androidmodule1.exercise.home.salvadorchavez.exercise1
>>>>>>>> origin/main:app/src/main/java/com/cvgs/androidmodule1/exercise/home/salvadorchavez/exercise1/ChavaFirstHomeworkActivity.kt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

<<<<<<<< HEAD:app/src/main/java/com/cvgs/androidmodule1/exercise/home/salvadorchavez/Exercise1/ChavaMenuExercise1Activity.kt
class ChavaMenuExercise1Activity : AppCompatActivity() {
========
class ChavaFirstHomeworkActivity : AppCompatActivity() {
>>>>>>>> origin/main:app/src/main/java/com/cvgs/androidmodule1/exercise/home/salvadorchavez/exercise1/ChavaFirstHomeworkActivity.kt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chava_menu_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnActividad1 = findViewById<Button>(R.id.btnChavaLifeCycle)
        val btnActividad2 = findViewById<Button>(R.id.btnChavaImplicitIntent)
        val btnActividad3 = findViewById<Button>(R.id.btnChavaParametros)

        btnActividad1.setOnClickListener{
            val lifeCicleIntent = Intent(this, ChavaLifeCycleActivity::class.java)
            startActivity(lifeCicleIntent)
        }

        btnActividad2.setOnClickListener{
            val implicitIntent = Intent(this, ChavaImplicitIntentActivity::class.java)
            startActivity(implicitIntent)
        }

        btnActividad3.setOnClickListener{
            val twoIntents = Intent(this, ChavaFirstActivity::class.java)
            startActivity(twoIntents)
        }


    }
}