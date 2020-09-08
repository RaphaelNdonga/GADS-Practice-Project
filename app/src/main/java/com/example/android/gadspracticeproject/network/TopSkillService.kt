package com.example.android.gadspracticeproject.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface TopSkillService {
    @GET("api/skilliq")
    fun getTopSkill():Deferred<List<TopSkillDetails>>
}