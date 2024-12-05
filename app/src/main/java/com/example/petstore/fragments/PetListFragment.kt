package com.example.petstore.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.petstore.data.recyclers.PetAdapter
import com.example.petstore.databinding.FragmentPetListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PetListFragment : Fragment() {
    private val viewModel: PetListFragmentViewModel by viewModels()

    private var binding: FragmentPetListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPetListBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.recycler?.layoutManager = GridLayoutManager(context, 2)
        val adapterRcView = PetAdapter { pet ->
            Toast.makeText(context, pet.name, Toast.LENGTH_SHORT).show()
        }
        binding?.recycler?.adapter = adapterRcView

        viewModel.inputPets.observe(viewLifecycleOwner) { pets ->
            adapterRcView.submitList(pets)
        }
        viewModel.getPets()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}