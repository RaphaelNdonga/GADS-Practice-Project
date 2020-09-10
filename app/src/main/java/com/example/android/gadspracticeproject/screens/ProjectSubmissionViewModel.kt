package com.example.android.gadspracticeproject.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.gadspracticeproject.network.ProjectSubmissionApi
import com.example.android.gadspracticeproject.network.ProjectSubmissionApiService
import com.example.android.gadspracticeproject.util.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ProjectSubmissionViewModel : ViewModel() {
    private val projectSubmissionApiService: ProjectSubmissionApiService = ProjectSubmissionApi.retrofitService
    private val _navigator = MutableLiveData<Event<Unit>>()
    val navigator: LiveData<Event<Unit>>
        get() = _navigator

    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val githubLink = MutableLiveData<String>()

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main+job)



    fun submitProject(){
        val email = email.value
        val firstName = firstName.value
        val lastName = lastName.value
        val githubLink = githubLink.value
        if(email.isNullOrEmpty() || firstName.isNullOrEmpty() || lastName.isNullOrEmpty() || githubLink.isNullOrEmpty()){
            Log.i("SubmissionViewModel","All blanks should be filled")
            return
        }
        uiScope.launch {
            val projectSubmissionDeferred = projectSubmissionApiService.submitProject(
                email, firstName, lastName, githubLink
            )
            try {
                Log.i("SubmissionViewModel","Loading...")
                val submission = projectSubmissionDeferred.await()
                Log.i("SubmissionViewModel","Submission successful")
            }catch (e:Exception){
                Log.i("SubmissionViewModel","Error $e occurred")
            }
        }
        navigateToLeaderboard()
    }

    fun navigateToLeaderboard(){
        _navigator.value = Event(Unit)
    }
}