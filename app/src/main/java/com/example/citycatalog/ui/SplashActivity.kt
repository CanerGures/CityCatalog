package com.example.citycatalog.ui

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.citycatalog.R
import com.example.citycatalog.util.extStartActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                this@SplashActivity extStartActivity MainActivity::class.java
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()
    }
}