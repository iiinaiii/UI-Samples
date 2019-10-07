package com.iiinaiii.uisamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class HomeListData(val title: String)

class HomeListAdapter(private val dataList: List<HomeListData>) :
    RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    class HomeListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeListViewHolder(inflater.inflate(R.layout.item_home_list, parent, false))
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        val data = dataList[holder.adapterPosition]
        holder.title.text = data.title
    }

    override fun getItemCount() = dataList.size

}