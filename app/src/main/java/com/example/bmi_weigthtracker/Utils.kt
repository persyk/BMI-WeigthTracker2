package com.example.bmi_weigthtracker

import android.content.Context
import java.io.IOException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class Utils(private val context: Context,
                    private val dataList: ArrayList<HashMap<String, String>>) : BaseAdapter() {

    private val inflater: LayoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int { return dataList.size }
    override fun getItem(position: Int): Int { return position }
    override fun getItemId(position: Int): Long { return position.toLong() }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val dataitem = dataList[position]

        val rowView = inflater.inflate(R.layout.list_row, parent, false)
        rowView.findViewById<TextView>(R.id.row_id).text = dataitem.get("id")
        rowView.findViewById<TextView>(R.id.row_height).text = dataitem.get("height")
        rowView.findViewById<TextView>(R.id.row_weight).text = dataitem.get("weight")
        rowView.findViewById<TextView>(R.id.row_bmi).text = dataitem.get("bmi")
        rowView.findViewById<TextView>(R.id.row_date).text = dataitem.get("date")


        rowView.tag = position
        return rowView
    }
}