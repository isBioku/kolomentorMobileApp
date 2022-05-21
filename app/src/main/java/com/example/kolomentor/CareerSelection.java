package com.example.kolomentor;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Objects;

public class CareerSelection extends AppCompatActivity {


    CardView appDevelopmentCareer;
    ImageView svgAppDevCareer;

    //Dialog myDialog;
    ImageView closeBtn;
    LinearLayout cyber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.career_selection);
        //myDialog = new Dialog(this);




    }




    public void goToAppDevelopmentMentors (View view ) {
        appDevelopmentCareer = findViewById(R.id.appDevelopment);
        svgAppDevCareer = findViewById(R.id.appDevelopmentSVG);
        svgAppDevCareer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CareerSelection.this, ListOfMentors.class));
            }
        });
        appDevelopmentCareer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CareerSelection.this, ListOfMentors.class));

            }
        });
    }
//    public void popUpCard (View view) {
//        PopupMenu popupMenu = new PopupMenu(this, view);
//        popupMenu.inflate(R.menu.my_drawer_menu);
//        popupMenu.show();
//    }



    public void popUpCard (View view) {
        Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.activity_categories_popup);
        closeBtn = myDialog.findViewById(R.id.closePopUp);
        cyber = myDialog.findViewById(R.id.cyberSecurity);
        closeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                myDialog.dismiss();
            }
        });

        cyber.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        myDialog.show();
    }


}