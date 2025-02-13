package com.cvgs.androidmodule1.exercise.home.alexisescalona.exercise2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class AlexisComponentsActivity : AppCompatActivity() {
    private lateinit var tvExample : TextView
    private lateinit var etExample : EditText
    private lateinit var btExample : Button
    private lateinit var ivExample : ImageView
    private lateinit var ibExample : ImageButton
    private lateinit var cbExample : CheckBox
    private lateinit var rgExample : RadioGroup
    private lateinit var spExample : Spinner

    val clickListener = View.OnClickListener { viewClicked ->
        when(viewClicked.id){
            R.id.btExample ->{
                val cbStatus = cbExample.isChecked
                val selectedRgOption = getRgLabel(rgExample.checkedRadioButtonId, true)
                val itemSpinnerSelected = spExample.selectedItem

                if(etExample.text.toString().isNotEmpty()) {
                    Toast.makeText(this, "$itemSpinnerSelected", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.ibExample ->{
                Toast.makeText(this, "Click en image Botón", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alexis_components_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()

        btExample.setOnClickListener(clickListener)
        ibExample.setOnClickListener(clickListener)

        //CHECKBOX
        cbExample.isChecked = false
        cbExample.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                ivExample.visibility = View.GONE
            }else{
                ivExample.visibility = View.VISIBLE
            }
        }

        //RADIOGROUP
        rgExample.setOnCheckedChangeListener { group, checkedId ->
            val name = getRgLabel(checkedId, false)
            Toast.makeText(this, name, Toast.LENGTH_LONG).show()
        }

        val pass = etExample.text
        Toast.makeText(this, pass, Toast.LENGTH_SHORT).show()

        //SPINNER
        val data = arrayListOf("No seleccion", "México", "Argentina", "Colombia", "Ecuador", "Dinamarca", "España")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also{
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        spExample.adapter = adapter

        spExample.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = data[position]

                if(position == 0){
                    Toast.makeText(this@AlexisComponentsActivity, "Item no seleccionado", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@AlexisComponentsActivity, "Item seleccionado: $itemSelected", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        /*btExample.setOnClickListener{
            val cbEstatus = cbExample.isChecked
            Toast.makeText(this, "$cbEstatus", Toast.LENGTH_SHORT).show()
        }

        ivExample.setOnClickListener{
            Toast.makeText(this, etExample.text, Toast.LENGTH_SHORT).show()
        }*/
    }

    private fun initViews() {
        tvExample = findViewById(R.id.tvExample)
        etExample = findViewById(R.id.etExample)
        btExample = findViewById(R.id.btExample)
        ivExample = findViewById(R.id.ivExample)
        ibExample = findViewById(R.id.ibExample)
        cbExample = findViewById(R.id.cbExample)
        rgExample = findViewById(R.id.rgSex)
        spExample = findViewById(R.id.spExample)
    }

    private fun getRgLabel(checkedId: Int, isFromButton: Boolean): String {
        return when(checkedId){
            R.id.rbWoman ->{
                if(isFromButton) "M" else "Mujer"
            }
            R.id.rbMan ->{
                if(isFromButton) "H" else "Hombre"
            }
            else-> "Desconocido"
        }
    }

    override fun onResume(){
        super.onResume()
        tvExample.text = "Cargue el texto en el metodo onResume"
    }
}