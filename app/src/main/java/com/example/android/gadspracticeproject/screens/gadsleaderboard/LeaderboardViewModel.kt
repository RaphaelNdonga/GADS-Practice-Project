package com.example.android.gadspracticeproject.screens.gadsleaderboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.gadspracticeproject.util.Event

class LeaderboardViewModel : ViewModel() {

    private val _navigator = MutableLiveData<Event<Unit>>()
    val navigator:LiveData<Event<Unit>>
        get() = _navigator


    fun navigateToProjectSubmission(){
        Log.i("GADSViewModel","On click works")
        _navigator.value = Event(Unit)
    }
}