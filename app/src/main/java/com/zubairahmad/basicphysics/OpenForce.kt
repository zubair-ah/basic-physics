package com.zubairahmad.basicphysics

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class OpenForce : AppCompatActivity() {
    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_force)



        MobileAds.initialize(this, "ca-app-pub-9175625503877306~3126481783")

        mAdView = findViewById(R.id.openad)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(applicationContext,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
