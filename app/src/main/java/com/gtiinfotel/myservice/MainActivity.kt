package com.gtiinfotel.myservice

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      /*  var backgroundService=Intent(this,MyBackgroundservice::class.java)
        startService(backgroundService)*/

    checkPermissios()
        var foregroundService=Intent(this,MyForegroundService::class.java)
        startForegroundService(foregroundService)
    }


    fun checkPermissios()
    {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU)
        if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS)
            ,101)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==101)
        {
            for (i in grantResults)
            {
                if(grantResults[i]==PackageManager.PERMISSION_GRANTED)
                {
                        Toast.makeText(this,"Granted",Toast.LENGTH_LONG).show()
                }

            }
        }
        else
        {
            checkPermissios()

        }
    }
}