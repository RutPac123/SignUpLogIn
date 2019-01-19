package com.example.sai.signuplogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Animation top;
    Animation fadein;
    View mView;
    Button signupbtn;
    ImageView logo;
    ImageView logolight;
    ImageView girlsaying;
    Button loginme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mView = findViewById(R.id.login);
        signupbtn = findViewById(R.id.signup);
        logo = findViewById(R.id.logo);
        logolight = findViewById(R.id.logolight);
        girlsaying = findViewById(R.id.girlkey);
        loginme = findViewById(R.id.loginbtn);

        animate();  // method to apply alpha animation from 0 to 1

        top = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom);
        mView.startAnimation(top);


        fadein = AnimationUtils.loadAnimation(this,R.anim.fadein);
        top.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                girlsaying.startAnimation(fadein);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        loginme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, " Login Successful! :) ", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void animate(){
        final AlphaAnimation alpha = new AlphaAnimation(0.0f,1.0f);
        alpha.setDuration(1000);
        alpha.setRepeatCount(1);
        alpha.setRepeatMode(Animation.REVERSE);
        logo.startAnimation(alpha);

        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                logolight.startAnimation(alpha);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
