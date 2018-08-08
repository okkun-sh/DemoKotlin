package com.example.okkun.firstapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        var mlistview = findViewById<ListView>(R.id.hoge)
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayOf("1", "2", "3"))

        mlistview.adapter = adapter
    }
}
