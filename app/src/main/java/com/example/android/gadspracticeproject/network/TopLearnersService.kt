package com.example.android.gadspracticeproject.network

import retrofit2.http.GET

interface TopLearnersService {
    @GET("api/hours")
    suspend fun getTopLearners():List<TopLearner>
}