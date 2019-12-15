package com.iiinaiii.uisamples.ui.motionlayout.googlecalendar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.iiinaiii.uisamples.R
import com.iiinaiii.uisamples.ext.addSystemWindowInsetToPadding
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.fragment_google_calendar_like.*

class GoogleCalenderLikeFragment : Fragment(R.layout.fragment_google_calendar_like) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.hide()

        setupToolbar()
        setupGuestItem(person0)
        setupGuestItem(person1)
        setupGuestItem(person2)
        setupGuestItem(person3)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as? AppCompatActivity)?.supportActionBar?.show()
    }

    private fun setupToolbar() {
        toolbar.apply {
            addSystemWindowInsetToPadding(top = true)
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setupGuestItem(item: View) {
        item.setOnClickListener {
            showBottomSheet()
        }
    }

    private fun showBottomSheet() {
        startActivity(GoogleCalendarProfileActivity.createIntent(requireContext()))
    }
}