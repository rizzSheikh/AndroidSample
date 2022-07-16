package com.droid.sampletask

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.telephony.TelephonyManager
import android.widget.Toast


/**
 * Created by RIZWAN on 15-Jul-22.
 */
class CallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        try {
            println("Receiver start")

            val state = intent?.getStringExtra(TelephonyManager.EXTRA_STATE)

            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING) || state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {

                Toast.makeText(context, "Incoming Call Detected", Toast.LENGTH_SHORT).show()

                Handler().postDelayed(Runnable {
                    val i = Intent(context, IncomingCallActivity::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context!!.startActivity(i)
                }, 500)

            }

            if (state == TelephonyManager.EXTRA_STATE_OFFHOOK) {
                Toast.makeText(context, "Call Received State", Toast.LENGTH_SHORT).show()
            }

            if (state == TelephonyManager.EXTRA_STATE_IDLE) {
                Toast.makeText(context, "Call Idle State", Toast.LENGTH_SHORT).show()
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}