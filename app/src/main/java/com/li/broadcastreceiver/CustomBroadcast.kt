package com.li.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomBroadcast : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
            val content = p1?.getStringExtra("test")
            Toast.makeText(p0, "Custom broadcast $content", Toast.LENGTH_SHORT).show()

    }
}