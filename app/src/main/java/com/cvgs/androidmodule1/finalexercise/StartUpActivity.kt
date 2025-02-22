package com.cvgs.androidmodule1.finalexercise

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.databinding.ActivityStartUpBinding

class StartUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartUpBinding
    private var user: UserEntity? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityStartUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        user = intent.getSerializableExtra("EXTRA_USER", UserEntity::class.java)
        user?.let {
            binding.tvName.text = "Nombre: ${it.name}"
            binding.tvLastName.text = "Apellido: ${it.lastName}"
            binding.tvEmail.text = "E-Mail: ${it.email}"
            binding.tvPassword.text = "Password: ${it.password}"
            binding.tvSex.text = "Genero: ${it.gender}"
        }

        binding.btnHome.setOnClickListener {
            val secondScreen = Intent(this, FinalExerciseMainActivity::class.java)
            startActivity(secondScreen)
        }
    }



}