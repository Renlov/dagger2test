package com.fehosdsg7.dagger2.presentation.second

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fehosdsg7.dagger2.R
import com.fehosdsg7.dagger2.appComponent
import com.fehosdsg7.dagger2.databinding.FragmentSecondBinding
import com.fehosdsg7.dagger2.firstAndSecondComponent
import com.fehosdsg7.dagger2.presentation.first.MainViewModel

class SecondFragment : Fragment(R.layout.fragment_second) {
    private val viewModel : SecondViewModel by viewModels{
        requireContext().firstAndSecondComponent.viewModelFactory()
    }
    private val binding by viewBinding(FragmentSecondBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel

        binding.second1.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_mainFragment)
        }

        binding.second2.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }
}