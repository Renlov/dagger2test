package com.fehosdsg7.dagger2.presentation.third

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fehosdsg7.dagger2.R
import com.fehosdsg7.dagger2.appComponent
import com.fehosdsg7.dagger2.databinding.FragmentThirdBinding
import com.fehosdsg7.dagger2.thirdComponent

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private val binding by viewBinding(FragmentThirdBinding::bind)
    private val viewModel : ThirdViewModel by viewModels {
        requireContext().thirdComponent.viewModelFactory()
    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel

        binding.third.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }

    }
}