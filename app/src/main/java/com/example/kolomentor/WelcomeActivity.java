package com.example.kolomentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class WelcomeActivity extends AppCompatActivity {
    Button menteeButton, mentorButton;
    TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        setContentView(R.layout.activity_welcomepage);


        menteeButton = findViewById(R.id.menteeRegistrationButton);

        menteeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMenteeSignUp();
                finish();
            }
        });
        mentorButton = findViewById(R.id.mentor_Button);
        mentorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToMentorSignUp();
                finish();
            }
        });

    }

    public void goToMentorSignUp () {
        Intent intent = new Intent(WelcomeActivity.this, MentorSignUP.class);
        startActivity(intent);
    }

    public void goToMenteeSignUp () {
        Intent intent = new Intent(WelcomeActivity.this, MenteSignUpActivity.class);
        startActivity(intent);
    }


}