package com.example.kolomentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class MentorChoice extends AppCompatActivity {

    Button dontSelectMentorBtn, selectMentorBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mentor_choice);
    }


    public void selectMentorNo (View view) {
        dontSelectMentorBtn = findViewById(R.id.dontSelectMentor);
        dontSelectMentorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MentorChoice.this, ListOfMentors.class));
                finish();
            }
        });
    }

    public void selectMentorYes (View view) {
        selectMentorBtn = findViewById(R.id.selectMentor);
        selectMentorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MentorChoice.this, MenteeDashboard.class));
                finish();
            }
        });
    }
}