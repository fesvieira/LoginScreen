package com.example.loginscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.loginscreen.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val args: LoginFragmentArgs by navArgs()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Take texts off login and pass the data to next fragment, arguments were set
           on nav_graph */

        val usernameDeepLink = args.username
        binding.apply {
            editTextUsername.setText(usernameDeepLink)

            buttonConfirm.setOnClickListener {
                val username = editTextUsername.text.toString()
                val password = editTextPassword.text.toString()
                val action =
                    LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username, password)
                findNavController().navigate(action)
            }
        }
    }
}