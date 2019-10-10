package com.iiinaiii.uisamples.extendedfab

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
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

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            adapter = ExtendedFabListAdapter(
                dataList = (1..100).map { createExtendedFabData() }
            )
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    val fvip = linearLayoutManager.findFirstVisibleItemPosition()
                    val compVisiblePos =
                        linearLayoutManager.findFirstCompletelyVisibleItemPosition()
                    Log.d(
                        "aaa",
                        "state = $newState, firstVisible = $fvip, firstComp = $compVisiblePos"
                    )

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

    private fun createExtendedFabData(): ExtendedFabData {
        val avatar =
            resources.getDrawable(R.drawable.ic_avatar_smile_24dp, requireActivity().theme)
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
        return ExtendedFabData(avatar, name)
    }
}