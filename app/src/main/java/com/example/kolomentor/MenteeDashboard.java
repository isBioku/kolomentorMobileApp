package com.example.kolomentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.gridlayout.widget.GridLayout;

import java.util.Objects;

public class MenteeDashboard extends AppCompatActivity {
    GridLayout resourcesGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_of_mentor);

        setContentView(R.layout.activity_mentee_dashboard);
    }


    public void goToResources (View view ) {
        resourcesGrid  = findViewById(R.id.resources_materials);
        resourcesGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenteeDashboard.this, Resourcs_Activity.class));
            }
        });
    }
}