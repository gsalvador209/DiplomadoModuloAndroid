package com.cvgs.androidmodule1.exercise.home.ivanusielrj.homework1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R

class UsielHouseRegisterActivity : AppCompatActivity() {
    private lateinit var etName : EditText
    private lateinit var etPrice : EditText
    private lateinit var rbGroup : RadioGroup
    private lateinit var cbCreditCard : CheckBox
    private lateinit var spFrom : Spinner
    private lateinit var btSubmit : Button
    private lateinit var ibReturn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usiel_house_register_shared)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initView()

        val adress = listOf("","Cd. México", "Edo. México", "Toluca", "Queretaro", "Pachuca")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, adress)
        spFrom.adapter = adapter

        btSubmit.setOnClickListener {
            val name = etName.text.toString()
            val price = etPrice.text.toString()
            val sale = getSaleFromRadioGroup(rbGroup.checkedRadioButtonId, true)
            val credit = if (cbCreditCard.isChecked) "Sí" else "No"
            val adress = spFrom.selectedItem.toString()

            if (price.isEmpty() || sale == null) {
                Toast.makeText(this, "Por favor complete el cuestionario", Toast.LENGTH_SHORT).show()
            } else {
                showAlert(name, price, sale, credit, adress)
            }
        }

        ibReturn.setOnClickListener {
            finish()
        }


    }

    private fun initView() {
        etName = findViewById(R.id.etName)
        etName.visibility = View.VISIBLE

        etPrice = findViewById(R.id.etPrice)
        etPrice.visibility = View.VISIBLE

        rbGroup = findViewById(R.id.rbGroup)
        rbGroup.visibility = View.VISIBLE

        cbCreditCard = findViewById(R.id.cbCreditCard)
        cbCreditCard.visibility = View.VISIBLE

        spFrom = findViewById(R.id.spFrom)
        spFrom.visibility = View.VISIBLE

        btSubmit = findViewById(R.id.btSubmit)
        btSubmit.visibility = View.VISIBLE

        ibReturn = findViewById(R.id.ibReturn)
        ibReturn.visibility = View.VISIBLE

    }

    private fun getSaleFromRadioGroup(checkedId: Int, isFromButton: Boolean): String {
        return when(checkedId){
            R.id.rbRent ->{
                if(isFromButton) "Renta" else "Renta"
            }
            R.id.rbSale ->{
                if (isFromButton) "Venta" else "Venta"
            }
            else -> "Desconocido"
        }

    }

    private fun showAlert(name: String, price: String, sale: String, credit: String, adress: String) {
        val message = """
            Case de: $name
            Con un precio: $ $price
            Tipo de venta: $sale
            ¿Aceptas crédito? $credit
            Ubicacion : $adress
        """.trimIndent()

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Los datos de la casa son:")
            .setMessage(message)
            .setPositiveButton("Enviar") { dialog, which ->
                val newHouse = UsielHouseEntity(name, "$ $price", sale, "Acepta crédito: $credit", "Ubicada en $adress")
                val houseList = intent.getSerializableExtra("houseList") as? ArrayList<UsielHouseEntity>?: arrayListOf(
                    UsielHouseEntity("Armando Gonzalez", "$ 10000", "Renta", "Acepta crédito: Sí", "Ubicada en Cd. México"),
                    UsielHouseEntity("Enrique Garcia", "$ 2000000", "Venta", "Acepta crédito: No", "Ubicada en Queretaro")
                )
                houseList.add(newHouse)
                val viewHouse = Intent(this, UsielHouseRecyclerviewActivity::class.java)
                viewHouse.putExtra("houseList", houseList)
                startActivity(viewHouse)
                Toast.makeText(this, "Gracias, tu solicitud ha sido registrada", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Cancelar", null)
            .create()
        alertDialog.show()
    }
}