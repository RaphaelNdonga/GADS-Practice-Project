package com.example.android.gadspracticeproject.screens.gadsleaderboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.gadspracticeproject.network.TopLearnersService

@Suppress("UNCHECKED_CAST")
class LearnerViewModelFactory(private val topLearnersService: TopLearnersService):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LearnerViewModel(topLearnersService) as T
    }
}