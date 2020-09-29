package com.example.aleemullah.fingerfood.userSection

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.aleemullah.fingerfood.adminSection.LoginActivity
import com.example.aleemullah.fingerfood.R
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        //Set OnClickListener on Table Login Button

        tableLogin.setOnClickListener {

            val intent = Intent(this,LoginTable::class.java)
            startActivity(intent)
        }

        //Set OnClickListener on Admin Login Button

        AdminLogin.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
