package com.example.loginscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.loginscreen.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    // Variables to get args configured on nav_graph
    private val args: WelcomeFragmentArgs by navArgs()

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            // The way to recover each arg
            textViewUsername.text = args.username
            textViewPassword.text = args.password

            // Return to start (Home Fragment)
            buttonOk.setOnClickListener {
                val action = WelcomeFragmentDirections.actionWelcomeFragmentToFragmentHome()
                findNavController().navigate(action)
            }
        }
    }

}