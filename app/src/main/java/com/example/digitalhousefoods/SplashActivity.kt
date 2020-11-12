package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
//        Splash Activity para
        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        },1000)
    }
}