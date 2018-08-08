package com.example.okkun.firstapplication.api

import com.example.okkun.firstapplication.data.Episode
import retrofit2.Call
import retrofit2.http.GET

interface EpisodeApiService {
    @GET("episode/list/json")
    fun apiEpisode(): Call<List<Episode>>
}