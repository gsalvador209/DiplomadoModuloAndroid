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
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spannableString = SpannableString(getString(R.string.no_account))
        val registeredUser = arguments?.getSerializable("EXTRA_USER", UserEntity::class.java)

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

        binding.etEmail.hint = getString(R.string.email_hint)
        binding.etPassword.hint = getString(R.string.password_hint)
        binding.btnSignIn.text = getString(R.string.sign_in)

        binding.btnSignIn.setOnClickListener {
            var isValid = true
            if (binding.etEmail.isNotFilled()) {
                binding.etEmail.markAsInvalid()
                isValid = false
            }
            if (binding.etPassword.isNotFilled()) {
                binding.etPassword.markAsInvalid()
                isValid = false
            }

            if (isValid) {
                if (binding.etPassword.text.toString() == registeredUser?.password &&
                    binding.etEmail.text.toString() == registeredUser?.email) {

                    val title = when (registeredUser?.gender) {
                        getString(R.string.gender_male) -> getString(R.string.welcome_male)
                        getString(R.string.gender_female) -> getString(R.string.welcome_female)
                        getString(R.string.gender_other) -> getString(R.string.welcome_other)
                        else -> getString(R.string.login_error)
                    }

                    val message = registeredUser?.name ?: getString(R.string.login_error)

                    val alertDialog = AlertDialog.Builder(requireContext())
                        .setTitle(title)
                        .setMessage(message)
                        .setPositiveButton(R.string.btn_send) { _, _ ->
                            val intent = Intent(requireContext(), StartUpActivity::class.java).apply {
                                putExtra("EXTRA_USER", registeredUser)
                            }
                            startActivity(intent)
                        }
                        .create()
                    alertDialog.show()

                } else {
                    val alertDialog = AlertDialog.Builder(requireContext())
                        .setTitle("Ups!")
                        .setMessage(getString(R.string.login_error))
                        .setPositiveButton("OK", null)
                        .create()
                    alertDialog.show()
                }

            } else {
                val alertDialog = AlertDialog.Builder(requireContext())
                    .setTitle("Ups!")
                    .setMessage(getString(R.string.missing_data))
                    .setPositiveButton("OK", null)
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

