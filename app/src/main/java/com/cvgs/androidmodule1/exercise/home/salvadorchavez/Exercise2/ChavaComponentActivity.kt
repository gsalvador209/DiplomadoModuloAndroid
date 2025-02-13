package com.cvgs.androidmodule1.exercise.home.salvadorchavez.Exercise2

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

class ChavaComponentActivity : AppCompatActivity() {

    lateinit var tvExample : TextView //Es una variable que se va a inicializar después y global
    lateinit var etExample : EditText
    lateinit var cbExample : CheckBox
    lateinit var ibExample : ImageButton
    lateinit var ivExample : ImageView
    lateinit var btnExample : Button
    lateinit var rgExample: RadioGroup
    private lateinit var spExample : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chava_component)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Crear un listener como variable
        val clickListener = View.OnClickListener{ viewClicked ->
            when(viewClicked.id){
                R.id.btnExampple ->{
                    //Toast.makeText(this, "Click on Button", Toast.LENGTH_LONG).show()
                    val selectedRgOption = getRgLabel(rgExample.checkedRadioButtonId, true) //El atributo checkedRadioButtonID devuelve el seleccionado
                    //val selectedSpOption = g//
                    Toast.makeText(this,"$selectedRgOption", Toast.LENGTH_SHORT).show()
                    if(etExample.text.toString().isNotEmpty()){
                        Toast.makeText(this,"No se ha ingresado contraseña",Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.ibExample -> {
                    finish()
                }
            }



        }

        /*********************************************
                        COMPONENTES EN XML
         ********************************************/
        tvExample = findViewById(R.id.tvExample) //Ya no es necesario <>
        etExample = findViewById(R.id.etExample)
        ivExample = findViewById(R.id.ivExample)
        ibExample = findViewById(R.id.ibExample)
        cbExample = findViewById(R.id.cbExample)
        btnExample = findViewById(R.id.btnExampple)
        rgExample = findViewById(R.id.rgMood)
        spExample = findViewById(R.id.spExample)

        /***********************************************
                            LISTENERS
         *******************************************/
        btnExample.setOnClickListener(clickListener)
        ibExample.setOnClickListener(clickListener)


        /*ibExample.setOnClickListener{
            val cbStatus = cbExample.isChecked
            Toast.makeText(this,"$cbStatus",Toast.LENGTH_SHORT).show()
        }*/

        // For checkbox listener
//        cbExample.setOnCheckedChangeListener { buttonView, isChecked ->
//            if(isChecked){
//                ivExample.visibility = View.INVISIBLE
//            }else{
//                ivExample.visibility = View.VISIBLE
//            }
//        }

        //Radiogroup listener
        rgExample.setOnCheckedChangeListener{ group, checkedId ->
            val name = getRgLabel(checkedId,false)
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        }

        //Spinner definition
        val data = arrayListOf<String>("","Casa","Escuela","Trabajo","Afuera","Otro")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,data).also { //Aquí se llama un diseño de spiner, no el ID del XML
            //Also permite realizar acciones a partir de la instancia creada
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            //El simple_spiner es cuando ya se seleccionó un elemento
            //el dropdown es para mostrar todos los textos
        }
        spExample.adapter = adapter
        //Spiner listener

        spExample.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val itemSelected = data[position]

                if (position == 0) {
                    Toast.makeText(this@ChavaComponentActivity, "No ha seleccionado", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@ChavaComponentActivity,"Item Seleccionado: $itemSelected", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }


    override fun onResume() {
        super.onResume()
        tvExample.text = "Hola"

    }


}


private fun ChavaComponentActivity.getRgLabel(checkedId : Int, isFromButton : Boolean) : String {
    return when(checkedId){
        R.id.rbHappy ->{
            if(isFromButton) "H" else "Happy"
        }

        R.id.rbSad -> {
            if (isFromButton) "S" else "Sad"
        }

        R.id.rbMad -> {
            if(isFromButton) "M" else "Mad"
        }

        R.id.rbBored -> {
            if(isFromButton) "B" else "Bored"
        }

        else -> "No seleccionó un estado de ánimo"
    }
}
