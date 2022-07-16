package com.droid.sampletask

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class IncomingCallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        try {

            super.onCreate(savedInstanceState)

            window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)

            setContentView(R.layout.activity_incoming_call)

        } catch (e:Exception) {
            e.printStackTrace()
        }
    }
}