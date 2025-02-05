package com.cvgs.androidmodule1.exercise.home.ivanusielrj

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class UsielCallActivityHomework : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var editAge: EditText
    private lateinit var editGen: EditText
    private lateinit var btnCallSecondScreen: Button
    private lateinit var btnReturn: ImageButton


    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT", false)
            Toast.makeText(this,"RESULT_OK : $isCorrect", Toast.LENGTH_LONG).show()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Return info:")
                .setMessage("$result")
                .setPositiveButton("Ok") { dialog, which ->
                }.show()
        }
        else{
            val isIncorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT", false)
            Toast.makeText(this,"RESULT_CANCELLED : $isIncorrect", Toast.LENGTH_LONG).show()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Return info:")
                .setMessage("$result")
                .setPositiveButton("Ok") { dialog, which ->
                }.show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_call_homework_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editName =findViewById(R.id.editName)
        editName.visibility = View.VISIBLE

        editAge = findViewById(R.id.editAge)
        editAge.visibility = View.VISIBLE

        editGen = findViewById(R.id.editGen)
        editGen.visibility = View.VISIBLE

        btnCallSecondScreen = findViewById(R.id.btnCallSecondScreen)
        btnCallSecondScreen.visibility = View.VISIBLE

        btnReturn = findViewById(R.id.btnReturn)
        btnReturn.visibility = View.VISIBLE

        btnCallSecondScreen.setOnClickListener {
            val  gen = editGen.text.toString()
            val age = editAge.text.toString().toIntOrNull() ?: 0
            val name = editName.text.toString()
            val secondIntent = Intent(this, UsielReturnInfoActivityHomework::class.java).apply {
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_AGE", age)
                putExtra("EXTRA_GEN", gen)

            }
            register.launch(secondIntent)
        }

        btnReturn.setOnClickListener {
            finish()
        }
    }
}