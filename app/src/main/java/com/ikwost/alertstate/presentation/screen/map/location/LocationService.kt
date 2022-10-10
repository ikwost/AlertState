package com.ikwost.alertstate.presentation.screen.map.location

import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.android.gms.location.LocationServices
import com.ikwost.alertstate.R
import com.ikwost.alertstate.util.Constants
import com.ikwost.alertstate.util.Constants.LOCATION_SERVICE_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LocationService : Service() {
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    //TODO use DI
    private lateinit var locationClient: LocationClient


    override fun onCreate() {
        super.onCreate()
        locationClient = DefaultLocationClient(
            applicationContext,
            LocationServices.getFusedLocationProviderClient(applicationContext)
        )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_START -> start()
            ACTION_STOP -> stop()
        }
        return super.onStartCommand(intent, flags, startId)
    }


    private fun start() {
        val notification = NotificationCompat.Builder(this, LOCATION_SERVICE_ID)
            .setContentTitle("Tracking location...")
            .setContentText("Location null")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setOngoing(true)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        locationClient
            .getLocationUpdates(5000L)
            .catch { e -> e.printStackTrace() } // TODO MessageBar
            .onEach { location ->
                val lat = location.latitude.toString()
                val long = location.longitude.toString()
                val updateNotification = notification.setContentText("Location: ($lat,$long)")
                notificationManager.notify(1, updateNotification.build())

                //TODO not working on 24 api, need to fix
            }
            .launchIn(serviceScope)



        startForeground(1, notification.build()) //TODO id to Constant

    }

    private fun stop() {
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }


    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_STOP = "ACTION_STOP"
    }
}