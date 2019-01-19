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

public class SignUpActivity extends AppCompatActivity {

    Button loginbtn;
    View myView;
    Animation moveright;
    Animation fadein;
    ImageView logo;
    ImageView logolight;
    Button signme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myView = findViewById(R.id.signup);
        loginbtn = findViewById(R.id.loginbtn);
        logo = findViewById(R.id.logo);
        logolight = findViewById(R.id.logolight);
        signme = findViewById(R.id.signupbtn);

        moveright = AnimationUtils.loadAnimation(this, R.anim.move); // moving to right animation

        fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        myView.startAnimation(fadein); // applying animation to the layout

        animate();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginbtn.startAnimation(moveright);
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));

            }
        });
        signme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignUpActivity.this, "You are Signed Up! :)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void animate(){
        final AlphaAnimation alpha = new AlphaAnimation(0.0f,1.0f);   // AplhaAnimation object to set animation from 0 to 1
        alpha.setDuration(1000);
        alpha.setRepeatCount(1);
        alpha.setRepeatMode(Animation.REVERSE); //Reversing the animations
        logo.startAnimation(alpha);

        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                logolight.startAnimation(alpha); // This animation will be applied after the 1st one.
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
