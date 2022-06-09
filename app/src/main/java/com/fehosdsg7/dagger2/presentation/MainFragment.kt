package com.fehosdsg7.dagger2.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.viewModelScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fehosdsg7.dagger2.R
import com.fehosdsg7.dagger2.appComponent
import com.fehosdsg7.dagger2.databinding.FragmentMainBinding
import com.fehosdsg7.dagger2.domain.IteratorClass
import dagger.Component
import dagger.Provides
import dagger.Subcomponent
import dagger.assisted.AssistedFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel : MainViewModel by viewModels{
        requireContext().appComponent.viewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.productLivaData.observe(viewLifecycleOwner){
            it.forEach {
                Log.d("spectra", it.toString())
            }
        }
    }
}