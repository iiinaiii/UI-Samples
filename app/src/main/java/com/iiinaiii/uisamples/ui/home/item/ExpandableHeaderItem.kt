package com.iiinaiii.uisamples.ui.home.item

import android.graphics.drawable.Animatable
import android.view.View
import com.iiinaiii.uisamples.R
import com.iiinaiii.uisamples.databinding.ItemExpandableHeaderBinding
import com.iiinaiii.uisamples.ui.home.HomeListData
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.databinding.BindableItem

class ExpandableHeaderItem(private val data: HomeListData) : BindableItem<ItemExpandableHeaderBinding>(), ExpandableItem {
    private lateinit var expandableGroup: ExpandableGroup

    override fun getLayout(): Int = R.layout.item_expandable_header

    override fun bind(viewBinding: ItemExpandableHeaderBinding, position: Int) {
        viewBinding.titleText.setText(data.type.titleId)
        viewBinding.expandIcon.apply {
            visibility = View.VISIBLE
            setImageResource(
                if (expandableGroup.isExpanded) {
                    R.drawable.collapse
                } else {
                    R.drawable.expand
                }
            )
            setOnClickListener {
                expandableGroup.onToggleExpanded()
                bindIcon(viewBinding)
            }
        }

    }

    private fun bindIcon(viewBinding: ItemExpandableHeaderBinding) {
        viewBinding.expandIcon.apply {
            visibility = View.VISIBLE
            setImageResource(if (expandableGroup.isExpanded) R.drawable.collapse_animated else R.drawable.expand_animated)
            (drawable as Animatable).start()
        }
    }

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        this.expandableGroup = onToggleListener
    }
}