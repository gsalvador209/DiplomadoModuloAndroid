package com.cvgs.androidmodule1.exercise.classrom

import android.util.Log
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cvgs.androidmodule1.R

class LiveCicleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main) //Se asigna la interfaz gráfica a esa actividad
        Log.e("LifeCicle","onCreate being executed") //Como log de error
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Log.e("LifeCicle","onStart being executed") //Como log de error
    }

    override fun onResume() {
        super.onResume()
        Log.e("LifeCicle","onResume being executed") //Como log de error
    }

    override fun onPause() {
        super.onPause()
        Log.e("LifeCicle","onPause being executed") //Como log de error
    }

    override fun onStop() {
        super.onStop()
        Log.e("LifeCicle","onStop being executed") //Como log de error
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LifeCicle","onDestroy being executed") //Como log de error
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("LifeCicle","onRestart being executed") //Como log de error
    }
}