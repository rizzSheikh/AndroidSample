package com.droid.sampletask

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissionSetup()
    }

    private fun permissionSetup() {
        if (ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.READ_PHONE_STATE
            ) !=
            PackageManager.PERMISSION_GRANTED
        ) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.READ_CONTACTS
                )
            ) {
                //todo
            } else {
                val permission =
                    Array(2) { Manifest.permission.READ_PHONE_STATE; Manifest.permission.READ_CONTACTS }
                ActivityCompat.requestPermissions(
                    this,
                    permission,
                    121
                )
            }
        }
    }
}