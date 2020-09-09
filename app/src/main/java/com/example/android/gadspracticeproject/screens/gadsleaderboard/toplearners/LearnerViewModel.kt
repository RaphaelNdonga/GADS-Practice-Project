package com.example.android.gadspracticeproject.screens.gadsleaderboard.toplearners

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.gadspracticeproject.network.TopLearner
import com.example.android.gadspracticeproject.network.TopLearnersService
import kotlinx.coroutines.*
import java.lang.Exception

class LearnerViewModel(private val topLearnersService: TopLearnersService) : ViewModel() {
    private val _topLearners = MutableLiveData<List<TopLearner>>()
    val topLearner: LiveData<List<TopLearner>>
        get() = _topLearners
    private val job = Job()
    private val uiScope = CoroutineScope(job + Dispatchers.Main)

    init {
        getTopLearners()
    }
    private fun getTopLearners() {
        uiScope.launch {
            val getTopLearnersDeferred: Deferred<List<TopLearner>> =
                topLearnersService.getTopLearners()
            try {
                Log.i("LearnerViewModel","Loading...")
                val listData = getTopLearnersDeferred.await()
                Log.i("LearnerViewModel","Network Request successful")
                _topLearners.value = listData
            }
            catch (e:Exception){
                Log.i("LearnerViewModel","$e error")
                _topLearners.value = ArrayList()
            }
        }
    }
}