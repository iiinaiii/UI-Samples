package com.iiinaiii.uisamples.ui.motionlayout.googlecalendar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.iiinaiii.uisamples.R
import com.iiinaiii.uisamples.databinding.ActivityGoogleCalendarProfileBinding

class GoogleCalendarProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityGoogleCalendarProfileBinding>(this, R.layout.activity_google_calendar_profile)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, GoogleCalendarProfileActivity::class.java)
        }
    }
}