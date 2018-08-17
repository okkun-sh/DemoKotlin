package com.example.okkun.firstapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.okkun.firstapplication.data.Demo
import com.example.okkun.firstapplication.databinding.EpisodeListBinding

class DemoAdapter(var context: Context, var items: List<Demo>) : BaseAdapter() {
    private val inflater: LayoutInflater

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        var convertView = convertView
//        var holder: DemoViewHolder? = null
        var binding: EpisodeListBinding
        if (convertView == null) {
            binding = EpisodeListBinding.inflate(inflater, parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as EpisodeListBinding
        }
        binding.demo = getItem(position) as Demo
        return binding.root
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }


//    class DemoViewHolder(var textView: TextView)
}