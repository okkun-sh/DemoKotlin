package com.example.okkun.firstapplication.api

import com.example.okkun.firstapplication.data.Demo
import retrofit2.Call
import retrofit2.http.GET

/*
interface SampleApiService {
    @GET("api")
    fun apiDemo(): Call<Demo>
}
*/
interface SampleListApiService {
    @GET("api/list")
    fun apiDemoList(): Call<List<Demo>>
}