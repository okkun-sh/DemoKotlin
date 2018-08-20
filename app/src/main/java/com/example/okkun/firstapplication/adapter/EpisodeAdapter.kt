package com.example.okkun.firstapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.okkun.firstapplication.data.Episode
import com.example.okkun.firstapplication.databinding.EpisodeRowBinding

class EpisodeAdapter(var context: Context, var items: List<Episode>) : BaseAdapter() {
    private val inflater: LayoutInflater

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var binding: EpisodeRowBinding
        if (convertView == null) {
            binding = EpisodeRowBinding.inflate(inflater, parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as EpisodeRowBinding
        }
        binding.episode = getItem(position) as Episode
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
}