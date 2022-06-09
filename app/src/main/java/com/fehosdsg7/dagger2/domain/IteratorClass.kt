package com.fehosdsg7.dagger2.domain

import com.fehosdsg7.dagger2.data.MockData
import javax.inject.Inject

class IteratorClass @Inject constructor(private val repository : MockData) {
    fun getData() = repository.arrayList
}