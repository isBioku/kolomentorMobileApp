package com.example.kolomentor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Objects;

public class MentorDashboard extends AppCompatActivity {
    Button smsButton;
    BottomSheetDialog buttomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_mentor_dashboard);

        smsButton = findViewById(R.id.sms_button);
        buttomSheetDialog = new BottomSheetDialog(this);
        buttomSheet();

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttomSheetDialog.show();
            }
        });

        buttomSheetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private void buttomSheet() {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null, false);
        buttomSheetDialog.setContentView(view);
    }
}