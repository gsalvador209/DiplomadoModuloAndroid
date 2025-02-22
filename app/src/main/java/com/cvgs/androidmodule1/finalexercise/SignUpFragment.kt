package com.cvgs.androidmodule1.finalexercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.cvgs.androidmodule1.R
import com.cvgs.androidmodule1.databinding.FragmentSignUpBinding
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.isNotFilled
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.markAsInvalid
import com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils.resetOnTyping


class SignUpFragment : Fragment() {

    private lateinit var binding : FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etName.resetOnTyping()
        binding.etLastName.resetOnTyping()
        binding.etEmail.resetOnTyping()
        binding.etPassword.resetOnTyping()
        binding.etPassword2.resetOnTyping()

        binding.btnSignIn.setOnClickListener{
            var isValid = true
            val selectedId = binding.rgSex.checkedRadioButtonId
            var sex = String()

            if (binding.etName.isNotFilled()){
                binding.etName.markAsInvalid()
                isValid = false
            }
            if (binding.etLastName.isNotFilled()){
                binding.etLastName.markAsInvalid()
                isValid = false
            }
            if (binding.etEmail.isNotFilled()){
                binding.etEmail.markAsInvalid()
                isValid = false
            }
            if (binding.etPassword.isNotFilled()){
                isValid = false
                binding.etPassword.markAsInvalid()

            }
            if (binding.etPassword2.isNotFilled()){
                isValid = false
                binding.etPassword2.markAsInvalid()
            }
            if (selectedId == -1) {
                isValid = false
            } else {
                val selectedRadioButton = binding.root.findViewById<RadioButton>(selectedId)
                sex = selectedRadioButton.text.toString()
            }


            if(!isValid){
                //Toast.makeText(requireContext(),"Llena los campos faltantes", Toast.LENGTH_SHORT).show()
                val message = """Favor de llenar los datos faltantes """.trimIndent()
                val alertDialog = AlertDialog.Builder(requireContext())
                    .setTitle("Datos incompletos")
                    .setMessage(message)
                    .setPositiveButton("OK") { dialog, which -> }
                    .create()
                alertDialog.show()
            }else if (binding.etPassword.text.toString() != binding.etPassword2.text.toString()){
                //Toast.makeText(requireContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                val message = """Las contaseñas no coinciden """.trimIndent()
                val alertDialog = AlertDialog.Builder(requireContext())
                    .setTitle("Error al introducir los datos")
                    .setMessage(message)
                    .setPositiveButton("OK") { dialog, which ->
                        binding.etPassword.setText("")
                        binding.etPassword2.setText("")
                        binding.etPassword.markAsInvalid()
                        binding.etPassword2.markAsInvalid()
                    }
                    .create()
                alertDialog.show()


            }
            else {
                val user = UserEntity(
                    binding.etName.text.toString(),
                    binding.etLastName.text.toString(),
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString(),
                    sex
                )
                val message = """
            Nombre : ${user.name}
            Apellido: ${user.lastName}
            E-Mail:  ${user.email}
            Genero: ${user.gender}
        """.trimIndent()

                val alertDialog = AlertDialog.Builder(requireContext())
                    .setTitle("Los datos que ingresaste son:")
                    .setMessage(message)
                    .setPositiveButton("Enviar") { dialog, which ->
                        val bundle = Bundle()
                        bundle.putSerializable("EXTRA_USER", user)
                        val fragment = LoginFragment()
                        fragment.arguments = bundle
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, fragment)
                            .addToBackStack("LoginFragment")
                            .commit()
                        Toast.makeText(requireContext(), "Gracias, ahora puedes ingresar tu usuario  y contraseña", Toast.LENGTH_LONG).show()
                    }
                    .setNegativeButton("Cancelar", null)
                    .create()
                alertDialog.show()

                /*Toast.makeText(requireContext(), "$registeredUser", Toast.LENGTH_LONG).show()
                val intent = Intent(requireContext(), StartUpActivity::class.java).apply {
                    putExtra("EXTRA_USER", user)
                }
                startActivity(intent)*/

            }
        }
    }



    companion object {
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }
}