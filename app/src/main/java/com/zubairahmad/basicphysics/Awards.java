package com.zubairahmad.basicphysics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Awards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awards);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Awards.this,HomeActivity.class);
        startActivity(i);
        finish();
    }
}
