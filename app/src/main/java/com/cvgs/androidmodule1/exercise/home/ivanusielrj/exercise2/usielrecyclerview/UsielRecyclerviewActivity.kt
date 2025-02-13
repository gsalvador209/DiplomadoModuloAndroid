package com.cvgs.androidmodule1.exercise.home.ivanusielrj.exercise2.usielrecyclerview

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cvgs.androidmodule1.R

class UsielRecyclerviewActivity : AppCompatActivity() {

    private lateinit var rvUsers: RecyclerView
    private lateinit var ibReturn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_recyclerview_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.visibility = View.VISIBLE

        rvUsers = findViewById(R.id.rvUsers)
        rvUsers.visibility = View.VISIBLE

        val data = listOf(
            UsielUserEntity("Iván Usiel", 28, "usiel_jarquin@outlook.com"),
            UsielUserEntity("María López", 30, "maria_lopez@outlook.com"),
            UsielUserEntity("Pedro Martínez", 22, "pedro_mart@outlook.com"),
            UsielUserEntity("Ana González", 35, "ana_gonzalez@outlook.com")
        )

        val adapter = UsielUserAdapter(data)
        rvUsers.adapter = adapter

        rvUsers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        ibReturn.setOnClickListener {
            finish()
        }
    }
}