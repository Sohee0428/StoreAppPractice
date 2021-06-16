package com.example.storeapppractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.storeapppractice.R
import com.example.storeapppractice.datas.Store

class ListViewAdapter(val mContext: Context, val resId: Int, val list: List<Store>): ArrayAdapter<Store>(mContext,resId,list) {

    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var temp = convertView

        val row = temp ?: inflater.inflate(resId, null)

        val data = list[position]

        val storeNameTxt = row.findViewById<TextView>(R.id.storeNameTxt)
        val logoImg = row.findViewById<ImageView>(R.id.pizzalogoImg)

        storeNameTxt.text = data.name

        Glide.with(mContext)
            .load(data.logoURL)
            .into(logoImg)

        return row
    }
}