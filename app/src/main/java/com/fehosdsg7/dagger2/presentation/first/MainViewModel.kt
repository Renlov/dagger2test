package com.fehosdsg7.dagger2.presentation.first

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fehosdsg7.dagger2.domain.IteratorClass
import javax.inject.Inject

class MainViewModel @Inject constructor(iteratorClass : IteratorClass) : ViewModel() {
    private val _productLivaData = MutableLiveData<List<Int>>()
    val productLivaData: LiveData<List<Int>> = _productLivaData

    init {
        Log.d("AAA", "MainViewModel")
        _productLivaData.postValue(iteratorClass.getData())
    }
}