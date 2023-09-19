package com.example.jz_eventplanning_worker;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView2; // Declare the TextView
    private Button buttonLogin;
    private Button buttonRegister;
    // track the currently displayed layout
    private int currentLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); // hiding the action bar at the top

        // Find the textView2 view by its ID
        textView2 = findViewById(R.id.textView2);

        // Create a ScaleAnimation for rubber-band effect
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 1.1f, 1f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        // set animation properties
        scaleAnimation.setDuration(1000); // in milliseconds
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(Animation.INFINITE);

        // start the animation
        textView2.startAnimation(scaleAnimation);

        // create a handler to delay the transition to the new layout
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                loginRegisterPage();
            }
        },4000);

        // set the initial layout to activity_main.xml
        currentLayoutId = R.layout.activity_main;
    }

    private void loginRegisterPage(){
        setContentView(R.layout.login_register);
        currentLayoutId = R.layout.login_register;

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPage();
            }
        });

        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerPage();
            }
        });
    }

    private void loginPage(){
        setContentView(R.layout.login);
        currentLayoutId = R.layout.login;
    }

    private void registerPage(){
        setContentView(R.layout.register);
        currentLayoutId = R.layout.register;
    }
}