package com.zubairahmad.basicphysics

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            val intent= Intent(applicationContext,HomeActivity::class.java)
            startActivity(intent)
            finish()
        },2000)



    }

}
