package com.example.android.gadspracticeproject.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface TopLearnersService {
    @GET("api/hours")
    fun getTopLearners():Deferred<List<TopLearner>>
}