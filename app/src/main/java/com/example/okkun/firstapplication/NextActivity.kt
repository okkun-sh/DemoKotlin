package com.example.okkun.firstapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.example.okkun.firstapplication.adapter.DemoAdapter
import com.example.okkun.firstapplication.api.SampleListApiService
import com.example.okkun.firstapplication.data.Demo
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
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

        var mlistview = findViewById<ListView>(R.id.hoge)
        val items = List<Map<String, String>>(20, { i -> mapOf("title" to "title-$i", "detail" to "detail-$i")})

        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val client = retrofit.create(SampleListApiService::class.java)
        val call: Call<List<Demo>> = client.apiDemoList()

        call.enqueue(object: Callback<List<Demo>> {
            override fun onResponse(call: Call<List<Demo>>?, response: Response<List<Demo>>?) {
                val result   = response?.body()
                val resJson  = gson.toJson(result)
                val type     = object : TypeToken<List<Demo>>(){}.type
                val episodes = gson.fromJson<List<Demo>>(resJson, type)
//                val episodes = gson.fromJson<List<Demo>>(resJson, Demo::class.java)

                Log.v("hoge", "bar")
                var adapter = DemoAdapter(
                        this@NextActivity,
                        episodes
                )

                mlistview.adapter = adapter
//                var adapter = ArrayAdapter<String>(this@NextActivity, R.layout.sample_row)

            }

            override fun onFailure(call: Call<List<Demo>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}
