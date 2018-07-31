package com.example.okkun.firstapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.okkun.firstapplication.api.SampleApiService
import com.example.okkun.firstapplication.data.Demo
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NextActivity : AppCompatActivity() {
    private val url = "https://shi9jiri.net"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val textview = findViewById<TextView>(R.id.textView)
        val client = retrofit.create(SampleApiService::class.java)
        val call: Call<Demo> = client.apiDemo()
            call.enqueue(object : Callback<Demo> {
                override fun onResponse(call: Call<Demo>?, response: Response<Demo>?) {
                    val result  = response?.body()
                    val resJson = gson.toJson(result)
                    val demo    = gson.fromJson(resJson, Demo::class.java)

                    textview.text = demo.name
                }

                override fun onFailure(call: Call<Demo>?, t: Throwable?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })


    }
}
