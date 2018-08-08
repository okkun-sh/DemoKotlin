package com.example.okkun.firstapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.okkun.firstapplication.R
import com.example.okkun.firstapplication.data.Demo

class DemoAdapter(var context: Context, var items: List<Demo>) : BaseAdapter() {
    private val inflater: LayoutInflater

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        var holder: DemoViewHolder? = null

        convertView?.let {
            holder = it.tag as DemoViewHolder?
        } ?: run {
            convertView      = inflater.inflate(R.layout.episode_list, null)
            holder           = DemoViewHolder(convertView?.findViewById(R.id.title) as TextView)
            convertView?.tag = holder
        }

        holder?.let {
            it.textView.text = items.get(position).name
        }

        return convertView as View
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


    class DemoViewHolder(var textView: TextView)
}