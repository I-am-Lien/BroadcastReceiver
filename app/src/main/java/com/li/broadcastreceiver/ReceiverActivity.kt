package com.li.broadcastreceiver

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ReceiverActivity : AppCompatActivity() {
    private lateinit var broadcast: CustomBroadcast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)
        broadcast = CustomBroadcast()
        val filter = IntentFilter("Test.Broadcast")
        registerReceiver(broadcast,filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcast)
    }
}