package com.zubairahmad.basicphysics

import android.app.AlertDialog
import android.app.Service
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle

import android.support.v7.app.AppCompatActivity;

import android.view.View
import android.widget.Toast
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView


import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    lateinit var mAdView: AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        checkConnectivity()
        MobileAds.initialize(this, "ca-app-pub-9175625503877306~3126481783")

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


    }

    fun openIntro(view: View) {
        val intent = Intent(applicationContext, Intro::class.java)
        startActivity(intent)
        finish()
    }

    fun openMotion(view: View) {
        val intent = Intent(applicationContext, Motion::class.java)
        startActivity(intent)
        finish()
    }

    fun openForce(view: View) {
        val intent = Intent(applicationContext, OpenForce::class.java)
        startActivity(intent)
        finish()
    }

    fun openlm(view: View) {
        val intent = Intent(applicationContext, LawsMotion::class.java)
        startActivity(intent)
        finish()
    }

    fun openWork(view: View) {
        val intent = Intent(applicationContext, Work::class.java)
        startActivity(intent)
        finish()
    }

    fun openEnergy(view: View) {
        val intent = Intent(applicationContext, Energy::class.java)
        startActivity(intent)
        finish()

    }

    fun openPower(view: View) {
        val intent = Intent(applicationContext, Gravity::class.java)
        startActivity(intent)
        finish()

    }

    fun openWaves(view: View) {
        val intent = Intent(applicationContext, Waves::class.java)
        startActivity(intent)
        finish()
    }

    fun openSound(view: View) {
        val intent = Intent(applicationContext, Sound::class.java)
        startActivity(intent)
        finish()
    }

    fun openElectricity(view: View) {
        val intent = Intent(applicationContext, Electricity::class.java)
        startActivity(intent)
        finish()
    }

    fun openMagneticEffect(view: View) {
        val intent = Intent(applicationContext, MagneticeffectsofCu::class.java)
        startActivity(intent)
        finish()
    }

    fun openSourcesofEnergy(view: View) {
        val intent = Intent(applicationContext, SourcesOfEnergy::class.java)
        startActivity(intent)
        finish()
    }

    fun openSolarSystem(view: View) {
        val intent = Intent(applicationContext, Solarsystem::class.java)
        startActivity(intent)
        finish()
    }

    fun openLight(view: View) {
        val intent = Intent(applicationContext, Light::class.java)
        startActivity(intent)
        finish()
    }

    fun openReflectandRefract(view: View) {
        val intent = Intent(applicationContext, ReflectAndRefract::class.java)
        startActivity(intent)
        finish()
    }

    fun openInstruments(view: View) {
        val intent = Intent(applicationContext, Instruments::class.java)
        startActivity(intent)
        finish()
    }
    fun openQuiz(view: View) {
        val intent = Intent(applicationContext, Quiz::class.java)
        startActivity(intent)
        finish()


    }
    fun openAwards(view:View){
        val intent = Intent(applicationContext, Awards::class.java)
        startActivity(intent)
        finish()

    }
    fun openAstro(view: View){
        val intent = Intent(applicationContext, Astro::class.java)
        startActivity(intent)
        finish()

    }

    private fun checkConnectivity(){
        val cm=getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork!= null && activeNetwork.isConnectedOrConnecting
        if(!isConnected){

        }
    }

}
