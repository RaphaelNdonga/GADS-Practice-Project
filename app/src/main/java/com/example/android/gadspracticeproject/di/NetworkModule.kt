package com.example.android.gadspracticeproject.di

import com.example.android.gadspracticeproject.network.TopLearnersService
import com.example.android.gadspracticeproject.network.TopSkillService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://gadsapi.herokuapp.com/"

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).baseUrl(BASE_URL).build()
    }

    @Provides
    @Singleton
    fun provideTopLearnersService(retrofit: Retrofit):TopLearnersService{
        return retrofit.create(TopLearnersService::class.java)
    }

    @Provides
    @Singleton
    fun provideTopSkillService(retrofit: Retrofit):TopSkillService{
        return retrofit.create(TopSkillService::class.java)
    }
}