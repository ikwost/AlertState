package com.ikwost.alertstate

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.ikwost.alertstate.util.Constants
import com.ikwost.alertstate.util.Constants.LOCATION_SERVICE_ID
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application()