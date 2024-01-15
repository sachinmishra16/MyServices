package com.gtiinfotel.myservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyBackgroundservice :Service() {
    override fun onBind(intent: Intent?): IBinder? {
            return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        CoroutineScope(Dispatchers.IO).launch {
            while (true)
            {
                Log.d("serviceStatusBackground","Background Service running")
                delay(3000)

            }
        }
        return super.onStartCommand(intent, flags, startId)
    }


}