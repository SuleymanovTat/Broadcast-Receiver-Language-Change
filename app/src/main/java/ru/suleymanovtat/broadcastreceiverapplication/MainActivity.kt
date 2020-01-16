package ru.suleymanovtat.broadcastreceiverapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(mBroadcastReceiver,
                IntentFilter(Intent.ACTION_LOCALE_CHANGED));
        tvLocal.text = getLanguage()
    }

    var mBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            tvLocal.text = getLanguage()
        }
    }

    override fun onDestroy() {
        unregisterReceiver(mBroadcastReceiver)
        super.onDestroy()
    }

    fun getLanguage() = String.format("Local: %s", Locale.getDefault().language)
}
