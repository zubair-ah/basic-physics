package com.zubairahmad.basicphysics;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.*;
import com.zubairahmad.basicphysics.Model.Question;

public class Quiz extends AppCompatActivity {

    Button b1,b2,b3,b4;
    TextView timer,tquestiontxt;
    int total =0;
    int correct=0;
    int wrong=0;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        timer=findViewById(R.id.timertxt);
        tquestiontxt=findViewById(R.id.questiontxt);

        if(Connected()){
            updateQuestions();

            reverseTimer(100,timer);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Quiz.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

            builder.setMessage("Please enable internet to play.");
            builder.setTitle("Enable Internet");
            builder.show();
        }


    }

    private void updateQuestions() {
        total++;
        if(total>10){

            Intent i =new Intent(Quiz.this,ResultActivity.class);
            i.putExtra("total",String.valueOf(total-1));
            i.putExtra("correct",String.valueOf(correct));
            i.putExtra("incorrect",String.valueOf(wrong));
            startActivity(i);
            finish();
        }
        else{
            reference=FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question =dataSnapshot.getValue(Question.class);
                    tquestiontxt.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());







                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b1.getText().toString().equals(question.getAnswer())){
                                b1.setBackgroundColor(Color.GREEN);
                                   Handler mHandler = new Handler();
                               mHandler.postDelayed(new Runnable() {
                                       @Override
                                   public void run() {
                                       b1.setBackground(getDrawable(R.drawable.button_shape));
                                   }
                               },500);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;

                                        updateQuestions();
                                    }
                                },1000);
                            }
                            else {

                                wrong++;
                                b1.setBackgroundColor(Color.RED);
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackground(getDrawable(R.drawable.button_shape));
                                    }
                                },500);


                                if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                    Handler miHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b2.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                    Handler mmHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b3.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                    Handler myHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b4.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        updateQuestions();

                                    }
                                },1000);

                            }
                        }
                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b2.getText().toString().equals(question.getAnswer())){
                                b2.setBackgroundColor(Color.GREEN);
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b2.setBackground(getDrawable(R.drawable.button_shape));
                                    }
                                },500);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;

                                        updateQuestions();

                                    }
                                },1000);
                            }
                            else {

                                wrong++;
                                b2.setBackgroundColor(Color.RED);
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b2.setBackground(getDrawable(R.drawable.button_shape));
                                    }
                                },100);
                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                    Handler miHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                    Handler mmHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b3.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                    Handler myHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b4.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        updateQuestions();

                                    }
                                },1000);

                            }
                        }
                    });


                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b3.getText().toString().equals(question.getAnswer())){
                                b3.setBackgroundColor(Color.GREEN);
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b3.setBackground(getDrawable(R.drawable.button_shape));
                                    }
                                },500);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;

                                        updateQuestions();

                                    }
                                },1000);
                            }
                            else {

                                wrong++;
                                b3.setBackgroundColor(Color.RED);
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b3.setBackground(getDrawable(R.drawable.button_shape));
                                    }
                                },500);
                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                    Handler miHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }
                                else if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                    Handler mmHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b2.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                    Handler myHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b4.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        updateQuestions();

                                    }
                                },1000);

                            }
                        }
                    });
                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(b4.getText().toString().equals(question.getAnswer())){
                                b4.setBackgroundColor(Color.GREEN);
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b4.setBackground(getDrawable(R.drawable.button_shape));
                                    }
                                },500);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;

                                        updateQuestions();

                                    }
                                },1000);
                            }
                            else {

                                wrong++;
                                b4.setBackgroundColor(Color.RED);
                                Handler mHandler = new Handler();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b4.setBackground(getDrawable(R.drawable.button_shape));
                                    }
                                },500);
                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                    Handler miHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }
                                else if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                    Handler mmHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b2.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                    Handler myHandler = new Handler();
                                    mHandler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b3.setBackground(getDrawable(R.drawable.button_shape));
                                        }
                                    },500);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        updateQuestions();

                                    }
                                },1000);

                            }
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    }
    public void reverseTimer(int seconds, final TextView tv){
        new CountDownTimer(seconds *1000+1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                int seconds =(int)(millisUntilFinished/1000);
                int minutes =seconds/60;
                seconds=seconds%60;
                tv.setText(String.format("%02d",minutes)+":"+String.format("%02d",seconds));
            }

            @Override
            public void onFinish() {

                tv.setText("Completed");
                Intent myIntent=new Intent(Quiz.this,ResultActivity.class);
                myIntent.putExtra("total",String.valueOf(total));
                myIntent.putExtra("correct",String.valueOf(correct));
                myIntent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(myIntent);
                finish();
            }
        }.start();
    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Quiz.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
dialog.cancel();
            }
        });
        builder.setMessage("Are you sure you want to quit");
        builder.setTitle("Quit");
        builder.show();
    }
    private Boolean Connected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isConnected();


    }
}
