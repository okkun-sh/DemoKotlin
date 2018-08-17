package com.example.okkun.firstapplication

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.okkun.firstapplication.data.Demo
import com.example.okkun.firstapplication.databinding.ActivitySampleBinding

class DataBindActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sample)

        val binding = DataBindingUtil.setContentView<ActivitySampleBinding>(this, R.layout.activity_sample)
        var demo = Demo(id = 1, name = "hoge")
        binding.demo = demo
    }
}