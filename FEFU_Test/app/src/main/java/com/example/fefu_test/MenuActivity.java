package com.example.fefu_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button signin_btn;
    private Button signup_btn;
    private Button aboutus_btn;

    private Intent signin_intent;
    private Intent signup_intent;
    private Intent aboutus_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        signin_btn = findViewById(R.id.signin_btn);
        signup_btn = findViewById(R.id.signup_btn);
        aboutus_btn = findViewById(R.id.aboutus_btn);

        signin_btn.setOnClickListener(btnClickListener);
        signup_btn.setOnClickListener(btnClickListener);
        aboutus_btn.setOnClickListener(btnClickListener);

        signin_intent = new Intent(getApplicationContext(), Signin.class);
        signup_intent = new Intent(getApplicationContext(), Signup.class);
        aboutus_intent = new Intent(getApplicationContext(), Aboutus.class);
    }


    private Button.OnClickListener btnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.signin_btn:
                    startActivity(signin_intent);
                    System.out.println("Sign In");
                    break;

                case R.id.signup_btn:
                    startActivity(signup_intent);
                    System.out.println("Sign Up");
                    break;

                case R.id.aboutus_btn:
                    startActivity(aboutus_intent);
                    System.out.println("About Us");
                    break;
            }
        }
    };
}
