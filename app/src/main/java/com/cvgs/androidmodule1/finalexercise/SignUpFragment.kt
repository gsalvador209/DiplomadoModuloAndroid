
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
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Asignar hints desde strings.xml
        binding.etName.hint = getString(R.string.name_hint)
        binding.etLastName.hint = getString(R.string.last_name_hint)
        binding.etEmail.hint = getString(R.string.email_hint)
        binding.etPassword.hint = getString(R.string.password_hint)
        binding.etPassword2.hint = getString(R.string.repeat_password_hint)
        binding.btnSignIn.text = getString(R.string.create_account)

        binding.etName.resetOnTyping()
        binding.etLastName.resetOnTyping()
        binding.etEmail.resetOnTyping()
        binding.etPassword.resetOnTyping()
        binding.etPassword2.resetOnTyping()

        binding.btnSignIn.setOnClickListener {
            var isValid = true
            val selectedId = binding.rgSex.checkedRadioButtonId
            var sex = ""

            if (binding.etName.isNotFilled()) {
                binding.etName.markAsInvalid()
                isValid = false
            }
            if (binding.etLastName.isNotFilled()) {
                binding.etLastName.markAsInvalid()
                isValid = false
            }
            if (binding.etEmail.isNotFilled()) {
                binding.etEmail.markAsInvalid()
                isValid = false
            }
            if (binding.etPassword.isNotFilled()) {
                binding.etPassword.markAsInvalid()
                isValid = false
            }
            if (binding.etPassword2.isNotFilled()) {
                binding.etPassword2.markAsInvalid()
                isValid = false
            }
            if (selectedId == -1) {
                isValid = false
            } else {
                val selectedRadioButton = binding.root.findViewById<RadioButton>(selectedId)
                sex = selectedRadioButton.text.toString()
            }

            if (!isValid) {
                val alertDialog = AlertDialog.Builder(requireContext())
                    .setTitle(getString(R.string.error_data))
                    .setMessage(getString(R.string.incomplete_data))
                    .setPositiveButton("OK", null)
                    .create()
                alertDialog.show()
            } else if (binding.etPassword.text.toString() != binding.etPassword2.text.toString()) {
                val alertDialog = AlertDialog.Builder(requireContext())
                    .setTitle(getString(R.string.error_data))
                    .setMessage(getString(R.string.password_mismatch))
                    .setPositiveButton("OK") { _, _ ->
                        binding.etPassword.setText("")
                        binding.etPassword2.setText("")
                        binding.etPassword.markAsInvalid()
                        binding.etPassword2.markAsInvalid()
                    }
                    .create()
                alertDialog.show()
            } else {
                val user = UserEntity(
                    binding.etName.text.toString(),
                    binding.etLastName.text.toString(),
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString(),
                    sex
                )
                val message = """
                    ${getString(R.string.name_hint)}: ${user.name}
                    ${getString(R.string.last_name_hint)}: ${user.lastName}
                    ${getString(R.string.email_hint)}: ${user.email}
                    ${getString(R.string.gender_other)}: ${user.gender}
                """.trimIndent()

                val alertDialog = AlertDialog.Builder(requireContext())
                    .setTitle(getString(R.string.user_info_title))
                    .setMessage(message)
                    .setPositiveButton(getString(R.string.btn_send)) { _, _ ->
                        val bundle = Bundle()
                        bundle.putSerializable("EXTRA_USER", user)
                        val fragment = LoginFragment()
                        fragment.arguments = bundle
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, fragment)
                            .addToBackStack("LoginFragment")
                            .commit()
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.no_account),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    .setNegativeButton(getString(R.string.btn_cancel), null)
                    .create()
                alertDialog.show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }
}
