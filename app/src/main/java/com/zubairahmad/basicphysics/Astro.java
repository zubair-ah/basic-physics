package com.zubairahmad.basicphysics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdTargetingOptions;
import com.google.android.gms.ads.AdView;

public class Astro extends AppCompatActivity {


    private AdLayout adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astro);
        AdRegistration.setAppKey("7bad18433b8c4b3abcc6c608f1eff9c2");





           this.adView = (AdLayout) findViewById(R.id.adview);

        AdTargetingOptions adOptions = new AdTargetingOptions();
        // Optional: Set ad targeting options here.
        this.adView.loadAd(adOptions); // Retrieves an ad on background thread

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Astro.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
