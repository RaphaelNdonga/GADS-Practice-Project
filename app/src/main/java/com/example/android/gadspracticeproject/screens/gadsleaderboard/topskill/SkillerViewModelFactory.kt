package com.example.android.gadspracticeproject.screens.gadsleaderboard.topskill

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.gadspracticeproject.network.TopSkillService

@Suppress("UNCHECKED_CAST")
class SkillerViewModelFactory(private val topSkillService: TopSkillService):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SkillerViewModel(topSkillService) as T
    }
}