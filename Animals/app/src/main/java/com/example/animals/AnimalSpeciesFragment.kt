package com.example.animals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animals.databinding.FragmentAnimalSpeciesBinding

class AnimalSpeciesFragment : Fragment() {

    companion object {
        const val ANIMAL_CLASS = "animalClass"
        const val SEARCH_PREFIX = "https://en.m.wikipedia.org/wiki/"
    }

    private var _binding: FragmentAnimalSpeciesBinding? = null
    private val binding get() = _binding!!
    private lateinit var classId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            classId = it.getString(ANIMAL_CLASS).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalSpeciesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.speciesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.speciesRecyclerView.adapter = SpeciesAdapter(classId, this.requireContext())
        binding.speciesRecyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}