package com.cvgs.androidmodule1.exercise.home.ivanusielrj

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class UsielLinkButtonActvityHomework : AppCompatActivity() {

        private lateinit var btnTiktok: ImageButton
        private lateinit var btnReturn: ImageButton

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_usiel_link_button_actvity_homework_shared)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            btnTiktok = findViewById(R.id.btnTiktok)
            btnTiktok.visibility = View.VISIBLE

            btnReturn = findViewById(R.id.btnReturn)
            btnReturn.visibility = View.VISIBLE

            btnTiktok.setOnClickListener {
                val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vm.tiktok.com/ZMkbFVHe8/"))
                startActivity(Intent.createChooser(urlIntent,"Abrir usando:"))
            }

            btnReturn.setOnClickListener {
                finish()
            }
        }
}