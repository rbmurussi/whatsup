package br.edu.iesb.android2.whatsup.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.edu.iesb.android2.whatsup.R
import br.edu.iesb.android2.whatsup.databinding.FragmentLoginBinding
import br.edu.iesb.android2.whatsup.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.result.observe(viewLifecycleOwner) { result ->
            when(result.status) {
                "success" -> {
                    Toast.makeText(context, result.message, Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
                }
                else -> Toast.makeText(context, result.message, Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    fun login() {
        viewModel.login()

    }

    fun register() {
        viewModel.register()
        Toast.makeText(context, context?.getString(R.string.register_success), Toast.LENGTH_LONG).show()
    }

    fun forgotPassword() {
        viewModel.forgotPassword()
        Toast.makeText(context, context?.getString(R.string.forgot_success), Toast.LENGTH_LONG).show()
    }
}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}