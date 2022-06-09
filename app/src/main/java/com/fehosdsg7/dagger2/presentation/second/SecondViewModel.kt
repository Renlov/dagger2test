package com.fehosdsg7.dagger2.presentation.second

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SecondViewModel @Inject constructor() : ViewModel() {

    init {
        Log.d("AAA", "SecondViewModel")
    }
}