package com.example.citycatalog.ui

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.citycatalog.R
import com.example.citycatalog.util.extStartActivity


class SplashActivity : AppCompatActivity() {
    lateinit var animator: ValueAnimator
    lateinit var animationView: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        object : CountDownTimer(6000, 1000) {
            override fun onFinish() {
                this@SplashActivity extStartActivity MainActivity::class.java
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()

    }
}