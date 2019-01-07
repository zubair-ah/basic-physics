package com.zubairahmad.basicphysics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1 = findViewById(R.id.textView4);
        t2 = findViewById(R.id.textView6);
        t3 = findViewById(R.id.textView8);


        Intent i = getIntent();
        String questions = i.getStringExtra("total");
        String correct = i.getStringExtra("correct");
        String wrong = i.getStringExtra("incorrect");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);





    }

    public void openHome(View view) {
        Intent intent = new Intent(ResultActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ResultActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void openQuiz(View view) {
        Intent intent = new Intent(ResultActivity.this,Quiz.class);
        startActivity(intent);
        finish();
    }
}
