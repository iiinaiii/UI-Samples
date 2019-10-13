package com.iiinaiii.uisamples.ext

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Uri.launchViewAction(context: Context) {
    val intent = Intent(Intent.ACTION_VIEW, this)
    context.startActivity(intent)
}