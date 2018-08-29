package com.example.okkun.firstapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.okkun.firstapplication.R
import com.example.okkun.firstapplication.data.Episode
import com.example.okkun.firstapplication.databinding.EpisodeRowBinding
import kotlinx.android.synthetic.main.episode_row.view.*

//class EpisodeAdapter(var context: Context, var items: List<Episode>) : BaseAdapter() {
//    private val inflater: LayoutInflater
//
//    init {
//        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        var binding: EpisodeRowBinding
//        if (convertView == null) {
//            binding = EpisodeRowBinding.inflate(inflater, parent, false)
//            binding.root.tag = binding
//        } else {
//            binding = convertView.tag as EpisodeRowBinding
//        }
//        binding.episode = getItem(position) as Episode
//        return binding.root
//    }
//
//    override fun getItem(position: Int): Any {
//        return items[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getCount(): Int {
//        return items.size
//    }
//}

class EpisodeAdapter(var context: Context, var items: List<Episode>) : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var mTitle = view.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.episode_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTitle.text = items[position].title
    }

    override fun getItemCount() = items.size
}