package com.cvgs.androidmodule1.finalexercise

import android.content.Intent
import android.graphics.Color
import android.os.Build
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
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.databinding.FragmentLoginBinding
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.isNotFilled
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.markAsInvalid
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.resetOnTyping

class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /********************************
         *          Variables
         * **********************************/
        val spannableString = SpannableString("¿No tienes cuenta? Crear cuenta") //Para poder crear cuenta en texto
        //val registeredUser = arguments?.getSerializable("EXTRA_USER") as? UserEntity
        val registeredUser = arguments?.getSerializable("EXTRA_USER", UserEntity::class.java)
        /********************************************
        Span para Fragment de sign up
         **********************************************/
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, SignUpFragment.newInstance())
                    .addToBackStack("SignUpFragment")
                    .commit()
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
                if (binding.etPassword.text.toString() == registeredUser?.password  &&
                    binding.etEmail.text.toString() == registeredUser?.email){
                    if(registeredUser?.gender == "Hombre"){
                        //Toast.makeText(requireContext(), "Bienvenido, ${registeredUser?.name}", Toast.LENGTH_SHORT).show()
                        val message = """${registeredUser?.name}""".trimIndent()
                        val alertDialog = AlertDialog.Builder(requireContext())
                            .setTitle("Bienvenido")
                            .setMessage(message)
                            .setPositiveButton("Ingresar") { dialog, which ->
                                val intent = Intent(requireContext(), StartUpActivity::class.java).apply {
                                    putExtra("EXTRA_USER", registeredUser)
                                }
                                startActivity(intent)
                            }
                            .create()
                        alertDialog.show()

                    }else if(registeredUser?.gender == "Mujer"){
                        //Toast.makeText(requireContext(), "Bienvenida, ${registeredUser?.name}", Toast.LENGTH_SHORT).show()
                        val message = """${registeredUser?.name}""".trimIndent()
                        val alertDialog = AlertDialog.Builder(requireContext())
                            .setTitle("Bienvenida")
                            .setMessage(message)
                            .setPositiveButton("Ingresar") { dialog, which ->
                                val intent = Intent(requireContext(), StartUpActivity::class.java).apply {
                                    putExtra("EXTRA_USER", registeredUser)
                                }
                                startActivity(intent)
                            }
                            .create()
                        alertDialog.show()
                    }else if(registeredUser?.gender == "Otro"){
                        //Toast.makeText(requireContext(), "Bienvenide, ${registeredUser?.name}", Toast.LENGTH_SHORT).show()
                        val message = """${registeredUser?.name}""".trimIndent()
                        val alertDialog = AlertDialog.Builder(requireContext())
                            .setTitle("Bienvenide")
                            .setMessage(message)
                            .setPositiveButton("Ingresar") { dialog, which ->
                                val intent = Intent(requireContext(), StartUpActivity::class.java).apply {
                                    putExtra("EXTRA_USER", registeredUser)
                                }
                                startActivity(intent)
                            }
                            .create()
                        alertDialog.show()

                    }

                }else{
                    //Toast.makeText(requireContext(), "Correo o contraseña equivocados o no registrados", Toast.LENGTH_SHORT).show()
                    val message = """Correo o contraseña equivocados o no registrados""".trimIndent()
                    val alertDialog = AlertDialog.Builder(requireContext())
                        .setTitle("Ups!")
                        .setMessage(message)
                        .setPositiveButton("OK") { dialog, which -> }
                        .create()
                    alertDialog.show()
                }


            }else{
                //Toast.makeText(requireContext(),"Ingresa los datos faltantes", Toast.LENGTH_SHORT).show()
                val message = """Ingresa los datos faltantes""".trimIndent()
                val alertDialog = AlertDialog.Builder(requireContext())
                    .setTitle("Ups!")
                    .setMessage(message)
                    .setPositiveButton("OK") { dialog, which -> }
                    .create()
                alertDialog.show()

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}