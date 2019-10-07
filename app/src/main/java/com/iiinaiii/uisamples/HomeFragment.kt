package com.iiinaiii.uisamples

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.iiinaiii.uisamples.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.homeRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = HomeListAdapter(
                dataList = listOf(
                    HomeListData(HomeListType.EXTENDED_FAB)
                )
            ) { type ->
                when (type) {
                    HomeListType.EXTENDED_FAB -> {
                        findNavController().navigate(R.id.action_homeFragment_to_extendedFabFragment)
                    }
                }
            }
        }
    }
}