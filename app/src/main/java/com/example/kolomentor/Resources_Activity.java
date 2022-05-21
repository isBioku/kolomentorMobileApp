package com.example.kolomentor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupMenu;

import androidx.gridlayout.widget.GridLayout;

import java.util.Objects;

public class Resources_Activity extends AppCompatActivity {
    GridLayout messagesGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_of_mentor);

        setContentView(R.layout.resources_activity);

    }




    public void goToMessages (View view ) {

        messagesGrid = findViewById(R.id.community);
        messagesGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( Resources_Activity.this, Messages.class));
            }
        });

    }

    public void popUpVideoMaterials (View view) {
        PopupMenu popUpMenu = new PopupMenu(this,view);
        popUpMenu.inflate(R.menu.video_resources_menu);
        popUpMenu.show();


    }
}