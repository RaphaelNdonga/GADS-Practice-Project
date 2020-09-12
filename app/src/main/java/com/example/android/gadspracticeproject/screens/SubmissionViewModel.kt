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

class SubmissionViewModel : ViewModel() {
    private val projectSubmissionApiService: ProjectSubmissionApiService = ProjectSubmissionApi.retrofitService
    private val _navigator = MutableLiveData<Event<Unit>>()
    val navigator: LiveData<Event<Unit>>
        get() = _navigator
    private val _dialogStatus = MutableLiveData<Event<SubmissionStatus>>()
    val submissionStatus:LiveData<Event<SubmissionStatus>>
        get() = _dialogStatus

    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val githubLink = MutableLiveData<String>()

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main+job)



    fun checkFormStatus(){
        val email = email.value
        val firstName = firstName.value
        val lastName = lastName.value
        val githubLink = githubLink.value
        if(email.isNullOrEmpty() || firstName.isNullOrEmpty() || lastName.isNullOrEmpty() || githubLink.isNullOrEmpty()){
            Log.i("SubmissionViewModel","All blanks should be filled")
            _dialogStatus.value = Event(SubmissionStatus.UNSUCCESSFUL)
            return
        }
        _dialogStatus.value = Event(SubmissionStatus.CONFIRM)
    }
    fun submitProject(){
        uiScope.launch {
            val projectSubmissionDeferred = projectSubmissionApiService.submitProject(
                email.value!!, firstName.value!!, lastName.value!!, githubLink.value!!
            )
            try {
                Log.i("SubmissionViewModel","Loading...")
                projectSubmissionDeferred.await()
                Log.i("SubmissionViewModel","Submission successful")
                _dialogStatus.value = Event(SubmissionStatus.SUCCESSFUL)
            }catch (e:Exception){
                _dialogStatus.value = Event(SubmissionStatus.UNSUCCESSFUL)
                Log.i("SubmissionViewModel","Error $e occurred")
            }
        }
    }

    fun navigateToLeaderboard(){
        _navigator.value = Event(Unit)
    }
}