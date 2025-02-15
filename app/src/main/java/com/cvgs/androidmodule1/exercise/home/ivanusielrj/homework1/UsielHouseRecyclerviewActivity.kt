package com.cvgs.androidmodule1.exercise.home.ivanusielrj.homework1

import android.content.Intent
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

class UsielHouseRecyclerviewActivity : AppCompatActivity() {

    private lateinit var rvHouse: RecyclerView
    private lateinit var houseAdapter: UsielHouseAdapter
    private lateinit var houseList: ArrayList<UsielHouseEntity>
    private lateinit var ibReturn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_house_recyclerview_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initView();

        houseList = intent.getSerializableExtra("houseList") as? ArrayList<UsielHouseEntity>
            ?: ArrayList()

        houseAdapter = UsielHouseAdapter(houseList)
        rvHouse.adapter = houseAdapter

        rvHouse.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        ibReturn.setOnClickListener {
            val secondScreen = Intent(this, UsielHomeHouseRegisterActivity::class.java)
            startActivity(secondScreen)
        }

    }

    private fun initView() {
        rvHouse = findViewById(R.id.rvHouse)
        rvHouse.visibility = View.VISIBLE

        ibReturn = findViewById((R.id.ibReturn))
        ibReturn.visibility = View.VISIBLE
    }
}