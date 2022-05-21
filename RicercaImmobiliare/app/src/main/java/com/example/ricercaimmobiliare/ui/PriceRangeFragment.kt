package com.example.ricercaimmobiliare.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.ricercaimmobiliare.R
import com.example.ricercaimmobiliare.databinding.FragmentPriceRangeBinding
import com.example.ricercaimmobiliare.model.HouseViewModel

class PriceRangeFragment : Fragment() {

    private val sharedViewModel: HouseViewModel by activityViewModels()
    private var binding: FragmentPriceRangeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPriceRangeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            priceRangeFragment = this@PriceRangeFragment
        }
    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_priceRangeFragment_to_locationFragment)
    }

    fun cancelSearch() {
        findNavController().navigate(R.id.action_priceRangeFragment_to_welcomeFragment)
    }
}