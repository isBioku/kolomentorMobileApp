package com.example.kolomentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.gridlayout.widget.GridLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Objects;

public class MenteeDashboard extends AppCompatActivity{

    GridLayout homeGrid, resourcesGrid, communityDrid,  messagesGrid, profileGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_mentee_dashboard);




    }




    public void goToResources (View view ) {
        resourcesGrid  = findViewById(R.id.resources_materials);
        resourcesGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenteeDashboard.this, Resources_Activity.class));
            }
        });
    }

    public void goToMessages (View view) {
        messagesGrid = findViewById(R.id.messages);
        messagesGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenteeDashboard.this, Messages.class));
            }
        });
    }

}