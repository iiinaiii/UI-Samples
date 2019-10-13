package com.iiinaiii.uisamples.extendedfab

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iiinaiii.uisamples.R
import com.iiinaiii.uisamples.databinding.FragmentExtendedFabBinding

class ExtendedFabFragment : Fragment(R.layout.fragment_extended_fab) {

    private lateinit var binding: FragmentExtendedFabBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExtendedFabBinding.bind(view).also {
            it.lifecycleOwner = this
            it.viewModel = ExtendedFabViewModel()
        }
        setupRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_reference, menu)

        val referenceLink = menu.findItem(R.id.reference_link)
//        referenceLink.setOnMenuItemClickListener {
//
//        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = ExtendedFabListAdapter(
                dataList = (1..70).map { createExtendedFabData(it) }
            )
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL).apply {
                val dividerDrawable = ContextCompat.getDrawable(context, R.drawable.list_divider)
                dividerDrawable?.let { setDrawable(it) }
            })
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    val compVisiblePos = linearLayoutManager.findFirstCompletelyVisibleItemPosition()

                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        if (compVisiblePos == 0) {
                            // RecyclerView top
                            binding.viewModel?.isFabExtended?.postValue(true)
                        }
                    } else {
                        binding.viewModel?.isFabExtended?.postValue(false)
                    }
                }
            })
        }
    }

    private fun createExtendedFabData(num: Int): ExtendedFabData {
        val name = listOf(
            "Anim",
            "Ben",
            "Charlie",
            "David",
            "Eric",
            "Funny",
            "Goonie",
            "Hentom",
            "Izac",
            "Jeff",
            "Krric"
        ).random()
        val avatarUrl = "https://i.pravatar.cc/150?img=$num"
        return ExtendedFabData(avatarUrl, name)
    }
}