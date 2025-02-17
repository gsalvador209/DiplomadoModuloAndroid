package com.cvgs.androidmodule1.finalexercise

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity.RESULT_OK
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.databinding.FragmentLoginBinding
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.ChavaSignUpActivity
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.isNotFilled
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.markAsInvalid
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.resetOnTyping

class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    lateinit var register: ActivityResultLauncher<Intent>
    var registeredEmail: String? = null
    var registeredPassword: String? = null
    var registeredGender: String? = null
    var registeredName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /********************************
         *          Variables
         * **********************************/
        val spannableString = SpannableString("¿No tienes cuenta? Crear cuenta") //Para poder crear cuenta en texto
        register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == RESULT_OK){
                registeredEmail = result.data?.getStringExtra("EXTRA_EMAIL")
                registeredPassword = result.data?.getStringExtra("EXTRA_PASSWORD")
                registeredGender = result.data?.getStringExtra("EXTRA_SEX")
                registeredName = result.data?.getStringExtra("EXTRA_NAME")
                //Toast.makeText(this,"isCorrect: $isCorrect", Toast.LENGTH_SHORT).show()
            }
        }
        /********************************************
        Span para Intent de sign up
         **********************************************/
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                /*parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SignUpFragment.newInstance())
                    .addToBackStack("SignUpFragment")
                    .commit()*/
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = Color.MAGENTA
            }
        }

        spannableString.setSpan(clickableSpan, 19, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvSignUp.text = spannableString
        binding.tvSignUp.movementMethod = LinkMovementMethod.getInstance()

        /*************************************
        Listeners
         ************************************/
        binding.etEmail.resetOnTyping()
        binding.etPassword.resetOnTyping()

        binding.btnSignIn.setOnClickListener{
            var isValid = true
            if (binding.etEmail.isNotFilled()){
                binding.etEmail.markAsInvalid()
                isValid = false
            }
            if(binding.etPassword.isNotFilled()){
                binding.etPassword.markAsInvalid()
                isValid = false
            }

            if(isValid){
                //Inicia sesion
                if (binding.etPassword.text.toString() == registeredPassword &&
                    binding.etEmail.text.toString() == registeredEmail){
                    if(registeredGender == "Hombre"){
                        Toast.makeText(requireContext(), "Bienvenido, $registeredName", Toast.LENGTH_SHORT).show()
                    }else if(registeredGender == "Mujer"){
                        Toast.makeText(requireContext(), "Bienvenida, $registeredName", Toast.LENGTH_SHORT).show()
                    }else if(registeredGender == "Otro"){
                        Toast.makeText(requireContext(), "Bienvenide, $registeredName", Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(requireContext(), "Correo o contraseña equivocados o no registrados", Toast.LENGTH_SHORT).show()
                }


            }else{
                Toast.makeText(requireContext(),"Ingresa los datos faltantes", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}