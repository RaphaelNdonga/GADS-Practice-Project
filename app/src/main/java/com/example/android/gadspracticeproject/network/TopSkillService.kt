package com.example.android.gadspracticeproject.network

import retrofit2.http.GET

interface TopSkillService {
    @GET("api/skilliq")
    suspend fun getTopSkill():List<TopSkillDetails>
}