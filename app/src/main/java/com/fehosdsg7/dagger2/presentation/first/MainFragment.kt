package com.fehosdsg7.dagger2.presentation.first

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fehosdsg7.dagger2.R
import com.fehosdsg7.dagger2.appComponent
import com.fehosdsg7.dagger2.databinding.FragmentMainBinding
import com.fehosdsg7.dagger2.firstAndSecondComponent

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel : MainViewModel by viewModels{
        requireContext().firstAndSecondComponent.viewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.first.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment)
        }

        viewModel.productLivaData.observe(viewLifecycleOwner){
            it.forEach {
                Log.d("data", it.toString())
            }
        }
    }
}