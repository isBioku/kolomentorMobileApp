package com.example.kolomentor;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Objects;

public class CareerSelection extends AppCompatActivity {
    TextView graphic_and_design_text, programming_text, management_text;

    CardView appDevelopmentCareer, programmingTab , managementTab, graphicsAndDesignTab;
    ScrollView programmingScrollView, managementScrollView, graphicsAndDesignScrollView;
    ImageView svgAppDevCareer;


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

        graphic_and_design_text = findViewById(R.id.graphic_and_design_text_id);
        programming_text = findViewById((R.id.programming_text_id));
        management_text = findViewById(R.id.management_text_id);


        programmingScrollView = findViewById(R.id.programming_scroll_view_id);
        managementScrollView = findViewById(R.id.management_scroll_view_id);
        graphicsAndDesignScrollView = findViewById(R.id.graphics_and_design_scrollview_id);


        programmingTab = findViewById(R.id.programming_card_view_id);
        managementTab = findViewById(R.id.management_card_view_id);
        graphicsAndDesignTab = findViewById(R.id.graphics_and_design_cardview_id);


        programmingTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                programmingTab.getVisibility();
                    programmingTab.setBackgroundResource(R.drawable.tab_background_filled);
                    programming_text.setTextColor(Color.parseColor("#FFFFFF"));

                    //graphicsAndDesignTab.setRadius();
                    managementTab.setBackgroundResource(R.drawable.tab_background_unfilled);
                    management_text.setTextColor(Color.parseColor("#800020"));

                    graphicsAndDesignTab.setBackgroundResource(R.drawable.tab_background_unfilled);
                    graphic_and_design_text.setTextColor(Color.parseColor("#800020"));


                    programmingScrollView.setVisibility(View.VISIBLE);
                    managementScrollView.setVisibility(View.GONE);
                    graphicsAndDesignScrollView.setVisibility(View.GONE);


            }
        });



        managementTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    managementTab.setBackgroundResource(R.drawable.tab_background_filled);
                    management_text.setTextColor(Color.parseColor("#FFFFFF"));
                    management_text.setTextColor(Color.parseColor("#FFFFFF"));

                    //graphicsAndDesignTab.setRadius();
                    programmingTab.setBackgroundResource(R.drawable.tab_background_unfilled);
                    programming_text.setTextColor(Color.parseColor("#800020"));

                    graphicsAndDesignTab.setBackgroundResource(R.drawable.tab_background_unfilled);
                    graphic_and_design_text.setTextColor(Color.parseColor("#800020"));

                    managementScrollView.setVisibility(View.VISIBLE);
                    programmingScrollView.setVisibility(View.GONE);
                    graphicsAndDesignScrollView.setVisibility(View.GONE);


            }
        });


        graphicsAndDesignTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    graphicsAndDesignTab.setBackgroundResource(R.drawable.tab_background_filled);
                    graphic_and_design_text.setTextColor(Color.parseColor("#FFFFFF"));

                    //graphicsAndDesignTab.setRadius();
                    managementTab.setBackgroundResource(R.drawable.tab_background_unfilled);
                    programmingTab.setBackgroundResource(R.drawable.tab_background_unfilled);

                    programming_text.setTextColor(Color.parseColor("#800020"));
                    management_text.setTextColor(Color.parseColor("#800020"));

                    programmingScrollView.setVisibility(VISIBLE);
                    graphicsAndDesignScrollView.setVisibility(INVISIBLE);
                    managementScrollView.setVisibility(INVISIBLE);



                    graphicsAndDesignScrollView.setVisibility(View.VISIBLE);
                    programmingScrollView.setVisibility(View.GONE);
                    managementScrollView.setVisibility(View.GONE);



            }
        });

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