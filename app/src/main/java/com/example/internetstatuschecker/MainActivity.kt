package com.example.internetstatuschecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var connectivityObserver: ConnectivityObserver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectivityObserver = NetworkConnectivityObserver(applicationContext)

        GlobalScope.launch {
             connectivityObserver.observe().collect{
                 Log.d("##",it.name)
             }
        }

    }
}