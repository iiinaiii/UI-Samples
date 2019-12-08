package com.iiinaiii.uisamples.ui.motionlayout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.iiinaiii.uisamples.R
import com.iiinaiii.uisamples.ext.addSystemWindowInsetToPadding
import kotlinx.android.synthetic.main.activity_main.*

class GoogleCalenderLikeFragment : Fragment(R.layout.fragment_google_calendar_like) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? AppCompatActivity)?.supportActionBar?.hide()
        toolbar.addSystemWindowInsetToPadding(top = true)
    }
}