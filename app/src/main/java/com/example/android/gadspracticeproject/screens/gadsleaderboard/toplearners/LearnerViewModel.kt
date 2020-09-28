package com.example.android.gadspracticeproject.screens.gadsleaderboard.toplearners

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.gadspracticeproject.network.TopLearner
import com.example.android.gadspracticeproject.network.TopLearnersService
import com.example.android.gadspracticeproject.screens.gadsleaderboard.LeaderBoardApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LearnerViewModel(private val topLearnersService: TopLearnersService) : ViewModel() {
    private val _topLearners = MutableLiveData<List<TopLearner>>()
    val topLearner: LiveData<List<TopLearner>>
        get() = _topLearners
    private val _learnerApiStatus = MutableLiveData<LeaderBoardApiStatus>()
    val leaderBoardApiStatus:LiveData<LeaderBoardApiStatus>
        get() = _learnerApiStatus

    private val job = Job()
    private val uiScope = CoroutineScope(job + Dispatchers.Main)

    init {
        getTopLearners()
    }
    private fun getTopLearners() {
        uiScope.launch {
            try {
                Log.i("LearnerViewModel","Loading...")
                _learnerApiStatus.value = LeaderBoardApiStatus.LOADING
                val getTopLearnersAsync: List<TopLearner> = getTopLearnersAsync()
                Log.i("LearnerViewModel","Network Request successful")
                _learnerApiStatus.value = LeaderBoardApiStatus.SUCCESS
                _topLearners.value = getTopLearnersAsync
            }
            catch (e:Exception){
                Log.i("LearnerViewModel","$e error")
                _learnerApiStatus.value = LeaderBoardApiStatus.ERROR
                _topLearners.value = ArrayList()
            }
        }
    }
    private suspend fun getTopLearnersAsync() = topLearnersService.getTopLearners()

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}