package com.example.okkun.firstapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.okkun.firstapplication.adapter.EpisodeAdapter
import com.example.okkun.firstapplication.api.EpisodeApiService
import com.example.okkun.firstapplication.data.Episode
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.episode_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EpisodeListActivity : AppCompatActivity() {
    private val url = "https://shi9jiri.net"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.episode_list)

//        val mlistview = findViewById<ListView>(R.id.episode_list)
        recycler_view.layoutManager = LinearLayoutManager(this)

        val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val client = retrofit.create(EpisodeApiService::class.java)
        val call: Call<List<Episode>> = client.apiEpisodeList()

        call.enqueue(object: Callback<List<Episode>> {
            override fun onResponse(call: Call<List<Episode>>?, response: Response<List<Episode>>?) {
                val result= response?.body()
                val resJson= gson.toJson(result)
                val type= object : TypeToken<List<Episode>>(){}.type
                var episodes = gson.fromJson<List<Episode>>(resJson, type)
                var adapter = EpisodeAdapter(
                        this@EpisodeListActivity,
                        episodes
                )
                recycler_view.adapter = adapter
            }

            override fun onFailure(call: Call<List<Episode>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}
