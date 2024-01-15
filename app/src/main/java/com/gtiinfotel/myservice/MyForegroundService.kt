package com.gtiinfotel.myservice

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyForegroundService:Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @SuppressLint("ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        CoroutineScope(Dispatchers.IO).launch {
            while (true)
            {
                Log.d("serviceStatusForeground","Foreground Service running")
                delay(3000)

            }
        }
        var channelId="My Foreground"
        var notificationChannel=NotificationChannel(channelId,"Foreground Service",NotificationManager.IMPORTANCE_HIGH)
        var notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
        var notification=Notification.Builder(this,channelId).
                         setContentText("My Foreground Service Start")
                        .setContentTitle("Foreground Service")
            .setSmallIcon(R.drawable.gtilogo)


        startForeground(101,notification.build())
        return super.onStartCommand(intent, flags, startId)
    }
}