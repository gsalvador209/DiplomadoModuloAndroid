package com.cvgs.androidmodule1.homework.salvadorchavez.tarea1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.isNotFilled
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.markAsInvalid
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.resetOnTyping
import org.w3c.dom.Text

class ChavaLoginActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin : Button
    lateinit var register: ActivityResultLauncher<Intent>
    var registredEmail: String? = null
    var registredPassword: String? = null
    var registredGender: String? = null
    var registredName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chava_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /********************************
         *          Variables
         * **********************************/
        val textView = findViewById<TextView>(R.id.tvSignUp)
        val spannableString = SpannableString(getString(R.string.login_no_account)) //Listo en string.xml
        register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == RESULT_OK){
                registredEmail = result.data?.getStringExtra("EXTRA_EMAIL")
                registredPassword = result.data?.getStringExtra("EXTRA_PASSWORD")
                registredGender = result.data?.getStringExtra("EXTRA_SEX")
                registredName = result.data?.getStringExtra("EXTRA_NAME")
                //Toast.makeText(this,"isCorrect: $isCorrect", Toast.LENGTH_SHORT).show()
            }
        }

        /************lateinit var***********/
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnSignIn)


        /********************************************
                    Span para Intent de sign up
         **********************************************/
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(widget.context, ChavaSignUpActivity::class.java)
                register.launch(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = Color.MAGENTA
            }
        }

        spannableString.setSpan(clickableSpan, 19, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spannableString
        textView.movementMethod = LinkMovementMethod.getInstance()

        /*************************************
                        Listeners
         ************************************/

        etEmail.resetOnTyping()
        etPassword.resetOnTyping()



        btnLogin.setOnClickListener{
            var isValid = true
            if (etEmail.isNotFilled()){
                etEmail.markAsInvalid()
                isValid = false
            }
            if(etPassword.isNotFilled()){
                etPassword.markAsInvalid()
                isValid = false
            }

            if(isValid){
                //Inicia sesion
                if (etPassword.text.toString() == registredPassword &&
                    etEmail.text.toString() == registredEmail){
                    if(registredGender == "Hombre"){
                        Toast.makeText(this,
                            String.format(getString(R.string.login_welcome_male), registredName),
                            Toast.LENGTH_SHORT).show() //listo en string.xml
                    }else if(registredGender == "Mujer"){
                        Toast.makeText(this,
                            String.format(getString(R.string.login_welcome_female), registredName),
                            Toast.LENGTH_SHORT).show() // listo en string.xml

                    }else if(registredGender == "Otro"){
                        Toast.makeText(this,
                            String.format(getString(R.string.login_welcome_other), registredName),
                            Toast.LENGTH_SHORT).show() //listo en string.xml
                    }

                }else{
                    Toast.makeText(this, getString(R.string.login_error_credentials),Toast.LENGTH_SHORT).show() //Listo en string.xml
                }


            }else{
                Toast.makeText(this,getString(R.string.login_missing_fields), Toast.LENGTH_SHORT).show() //Listo en string.xml
            }
        }
    }

    override fun onPause() {
        super.onPause()
        etEmail.setText("")
        etPassword.setText("")
    }
}