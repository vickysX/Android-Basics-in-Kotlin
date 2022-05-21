package com.example.ricercaimmobiliare.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ricercaimmobiliare.R
import com.example.ricercaimmobiliare.databinding.FragmentWelcomeBinding
import com.example.ricercaimmobiliare.model.HouseViewModel

class WelcomeFragment : Fragment() {

    private val sharedViewModel: HouseViewModel by activityViewModels()
    private var binding: FragmentWelcomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.welcomeFragment = this@WelcomeFragment
    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_welcomeFragment_to_priceRangeFragment)
    }
}