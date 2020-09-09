package com.example.android.gadspracticeproject.screens.gadsleaderboard.topskill

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.gadspracticeproject.network.TopSkillDetails
import com.example.android.gadspracticeproject.network.TopSkillService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SkillerViewModel(private val topSkillService: TopSkillService): ViewModel() {
    private val _topSkillers = MutableLiveData<List<TopSkillDetails>>()
    val topSkillers: LiveData<List<TopSkillDetails>>
        get() = _topSkillers
    private val job = Job()
    private val uiScope = CoroutineScope(job+Dispatchers.Main)

    init {
        getTopSkillers()
    }

    private fun getTopSkillers(){
        uiScope.launch {
            val topSkillersDeferred = topSkillService.getTopSkill()
            try{
                Log.i("SkillerViewModel","Loading...")
                val listResult: List<TopSkillDetails> = topSkillersDeferred.await()
                Log.i("SkillerViewModel","Network fetch successful")
                _topSkillers.value = listResult
            }catch (e:Exception){
                Log.i("SkillerViewModel","Error $e")
            }
        }

    }

}