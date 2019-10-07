package com.iiinaiii.uisamples

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.iiinaiii.uisamples.databinding.FragmentExtendedFabBinding

class ExtendedFabFragment : Fragment(R.layout.fragment_extended_fab) {

    private lateinit var binding: FragmentExtendedFabBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExtendedFabBinding.bind(view)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ExtendedFabListAdapter(
                dataList = (1..100).map { createExtendedFabData() }
            )
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