package com.cvgs.androidmodule1.homework.salvadorchavez.tarea1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.isNotFilled
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.markAsInvalid
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.resetOnTyping

class ChavaSignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chava_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etName = findViewById<EditText>(R.id.etName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etPassword2 = findViewById<EditText>(R.id.etPassword2)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)
        val btnCreate = findViewById<Button>(R.id.btnSignIn)

        etName.resetOnTyping()
        etLastName.resetOnTyping()
        etEmail.resetOnTyping()
        etPassword.resetOnTyping()
        etPassword2.resetOnTyping()

        btnCreate.setOnClickListener{
            var isValid = true
            val selectedId = rgSex.checkedRadioButtonId
            var sex = String()

            if (etName.isNotFilled()){
                etName.markAsInvalid()
                isValid = false
            }
            if (etLastName.isNotFilled()){
                etLastName.markAsInvalid()
                isValid = false
            }
            if (etEmail.isNotFilled()){
                etEmail.markAsInvalid()
                isValid = false
            }
            if (etPassword.isNotFilled()){
                isValid = false
                etPassword.markAsInvalid()

            }
            if (etPassword2.isNotFilled()){
                isValid = false
                etPassword2.markAsInvalid()
            }
            if (selectedId == -1){
                isValid = false
            }else{
                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                sex = selectedRadioButton.text.toString()
            }


            if(!isValid){
                Toast.makeText(this,"Llena los campos faltantes", Toast.LENGTH_SHORT).show()
            }else if (etPassword.text.toString() != etPassword2.text.toString()){
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                etPassword.setText("")
                etPassword2.setText("")
                etPassword.markAsInvalid()
                etPassword2.markAsInvalid()

            }else{
                val loginActivity = Intent().apply {
                    putExtra("EXTRA_EMAIL",etEmail.text.toString())
                    putExtra("EXTRA_PASSWORD", etPassword.text.toString())
                    putExtra("EXTRA_NAME",etName.text.toString())
                    putExtra("EXTRA_LAST_NAME",etLastName.text.toString())
                    putExtra("EXTRA_SEX",sex)
                }
                setResult(RESULT_OK, loginActivity)
                finish() //Se finaliza esta actividad
            }
        }

    }
}

