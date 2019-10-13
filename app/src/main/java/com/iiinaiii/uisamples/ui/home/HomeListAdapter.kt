package com.iiinaiii.uisamples.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iiinaiii.uisamples.R

enum class HomeListType(val titleId: Int) {
    EXTENDED_FAB(R.string.title_extended_fab)
}

data class HomeListData(val type: HomeListType)

class HomeListAdapter(
    private val dataList: List<HomeListData>,
    private val onItemClick: (type: HomeListType) -> Unit
) :
    RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    class HomeListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeListViewHolder(
            inflater.inflate(
                R.layout.item_home_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        val data = dataList[position]
        holder.title.setText(data.type.titleId)
        holder.itemView.setOnClickListener {
            onItemClick.invoke(data.type)
        }
    }

    override fun getItemCount() = dataList.size

}