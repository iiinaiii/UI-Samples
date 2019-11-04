package com.iiinaiii.uisamples.ui.home.item

import com.iiinaiii.uisamples.R
import com.iiinaiii.uisamples.databinding.ItemHomeListChildBinding
import com.iiinaiii.uisamples.ui.home.HomeListData
import com.iiinaiii.uisamples.ui.home.HomeListType
import com.xwray.groupie.databinding.BindableItem

class HomeListChildItem(
    private val data: HomeListData,
    private val onItemClick: (type: HomeListType) -> Unit
) : BindableItem<ItemHomeListChildBinding>() {
    override fun getLayout(): Int = R.layout.item_home_list_child

    override fun bind(viewBinding: ItemHomeListChildBinding, position: Int) {
        viewBinding.titleText.setText(data.type.titleId)
        viewBinding.root.setOnClickListener {
            onItemClick.invoke(data.type)
        }
    }
}