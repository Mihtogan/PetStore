package com.example.petstore.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.petstore.databinding.FragmentStartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : Fragment() {
    private val viewModel: StartFragmentViewModel by viewModels()

    private var bindings: FragmentStartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        bindings = FragmentStartBinding.inflate(inflater, container, false)
        return bindings!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindings = null
    }
}