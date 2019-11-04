package com.iiinaiii.uisamples.ui.home.item

import com.iiinaiii.uisamples.R
import com.iiinaiii.uisamples.databinding.ItemHomeListBinding
import com.iiinaiii.uisamples.ui.home.HomeListData
import com.iiinaiii.uisamples.ui.home.HomeListType
import com.xwray.groupie.databinding.BindableItem

class HomeListItem(
    private val data: HomeListData,
    private val onItemClick: (type: HomeListType) -> Unit
) : BindableItem<ItemHomeListBinding>() {
    override fun getLayout(): Int = R.layout.item_home_list

    override fun bind(viewBinding: ItemHomeListBinding, position: Int) {
        viewBinding.titleText.setText(data.type.titleId)
        viewBinding.root.setOnClickListener {
            onItemClick.invoke(data.type)
        }
    }
}