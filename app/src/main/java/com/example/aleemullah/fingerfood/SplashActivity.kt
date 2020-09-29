package com.example.aleemullah.fingerfood

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.aleemullah.fingerfood.userSection.HomeScreen
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    //Override function onDestroy for animation

    override fun onDestroy() {
        super.onDestroy()

        //Override pendingTransitions to transition of screen

        overridePendingTransition(
            R.anim.fade_in,
            R.anim.fade_out
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //set animation on logo

        mylogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_in))

        //set handler here

        Handler().postDelayed({
            //Here to animate splash out

            mylogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_out))

            //Set handler

            Handler().postDelayed({

                //disable view after 500 milli seconds

                mylogo.visibility = android.view.View.GONE

                //Here to start new activity

                startActivity(Intent(this, HomeScreen::class.java))
                finish()
            },500)
        },2500)
    }
}
