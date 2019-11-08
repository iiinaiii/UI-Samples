package com.iiinaiii.uisamples.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.iiinaiii.uisamples.R
import com.iiinaiii.uisamples.databinding.FragmentHomeBinding
import com.iiinaiii.uisamples.ui.home.item.ExpandableHeaderItem
import com.iiinaiii.uisamples.ui.home.item.HomeListChildItem
import com.iiinaiii.uisamples.ui.home.item.HomeListItem
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.homeRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
        }

        val groupList: List<Group> = ParentHomeListType.values().map { parentType ->
            when {
                parentType.hasChild() -> {
                    ExpandableGroup(ExpandableHeaderItem(HomeListData(parentType)))
                        .apply {
                            parentType.children.forEach { childType ->
                                add(HomeListChildItem(HomeListData(childType)) {
                                    actionHomeList(it)
                                })
                            }
                        }
                }
                else -> {
                    HomeListItem(HomeListData(parentType)) {
                        actionHomeList(it)
                    }
                }
            }
        }
        val groupAdapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(groupList)
        }

        recyclerView.adapter = groupAdapter
    }

    private fun actionHomeList(type: HomeListType) {
        when (type) {
            ParentHomeListType.EXTENDED_FAB -> {
                findNavController().navigate(R.id.action_homeFragment_to_extendedFabFragment)
            }
            ChildHomeListType.MOTION_LAYOUT_SIMPLE_01 -> {
                findNavController().navigate(R.id.action_homeFragment_to_simpleMotionFragment01)
            }
            ChildHomeListType.MOTION_LAYOUT_YOUTUBE -> {

            }
        }
    }

}