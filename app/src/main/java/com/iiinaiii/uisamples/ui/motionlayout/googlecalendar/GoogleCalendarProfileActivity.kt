package com.iiinaiii.uisamples.ui.motionlayout.googlecalendar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.appbar.MaterialToolbar
import com.iiinaiii.uisamples.R
import com.iiinaiii.uisamples.databinding.ActivityGoogleCalendarProfileCoordinatorBinding

class GoogleCalendarProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityGoogleCalendarProfileCoordinatorBinding>(
            this,
            R.layout.activity_google_calendar_profile_coordinator
        )
        setupToolbar()
    }

    private fun setupToolbar() {
        findViewById<MaterialToolbar>(R.id.content_toolbar)?.apply {
            inflateMenu(R.menu.menu_reference)
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, GoogleCalendarProfileActivity::class.java)
        }
    }
}