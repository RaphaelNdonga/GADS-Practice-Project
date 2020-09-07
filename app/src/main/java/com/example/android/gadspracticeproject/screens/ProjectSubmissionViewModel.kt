package com.example.android.gadspracticeproject.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.gadspracticeproject.util.Event

class ProjectSubmissionViewModel : ViewModel() {
    private val _navigator = MutableLiveData<Event<Unit>>()
    val navigator: LiveData<Event<Unit>>
        get() = _navigator

    fun navigateToLeaderboard(){
        _navigator.value = Event(Unit)
    }
}