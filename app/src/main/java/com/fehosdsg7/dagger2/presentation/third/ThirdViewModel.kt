package com.fehosdsg7.dagger2.presentation.third

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ThirdViewModel @Inject constructor() : ViewModel() {
    init {
        Log.d("AAA", "ThirdViewModel")
    }
}