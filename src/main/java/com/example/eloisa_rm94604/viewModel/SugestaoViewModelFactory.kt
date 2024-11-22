package com.example.eloisa_rm94604.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

    class SugestaoViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SugestaoViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SugestaoViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }


    }