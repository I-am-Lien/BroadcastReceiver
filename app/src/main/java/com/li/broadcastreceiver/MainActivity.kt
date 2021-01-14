package com.li.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var intent: IntentFilter
    private lateinit var systemBroadcast: SystemBroadcast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //system broadcast
        intent = IntentFilter()
        systemBroadcast = SystemBroadcast()
        intent.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(systemBroadcast, intent)

        btnStart.setOnClickListener {
            //Custom broadcast
            val intent = Intent()
            intent.action = "Test.Broadcast"
            intent.putExtra("test","CustomBroadcast send data")
            sendBroadcast(intent)
            val move = Intent(this, ReceiverActivity::class.java)
            startActivity(move)

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(systemBroadcast)
    }
}