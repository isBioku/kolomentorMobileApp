package com.example.kolomentor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MentorSignUP extends AppCompatActivity {
    private FirebaseAuth authentication;

    private EditText last_name_field, first_name_field, email_field, password_field, re_enter_password_field;
    LinearLayout mentorCareerSelectionLayout;

    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;
    Button mentorSignUpBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_mentor_sign_up);

        textInputLayout = findViewById(R.id.text_input_layout_id);
        autoCompleteTextView = findViewById(R.id.auto_complete_text_view_id);

        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listOfMentorCareerPopUp();
            }
        });

        mentorCareerSelectionLayout = findViewById(R.id.careerSelectionLayout);
        mentorCareerSelectionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listOfMentorCareerPopUp();
            }
        });


        mentorSignUpBtn = findViewById(R.id.smentor_ign_up_button_id);
        mentorSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMentorDashboard();
            }
        });

    }

    public void goToMentorDashboard (  ) {
        String  email_patterns =  "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        authentication = FirebaseAuth.getInstance();
        last_name_field = findViewById(R.id.last_name_id);
        first_name_field = findViewById(R.id.first_name_id);
        email_field = findViewById(R.id.email_id);
        password_field = findViewById(R.id.password_id);
        re_enter_password_field = findViewById(R.id.re_enter_password_id);


        String lastName = last_name_field.getText().toString().trim();
        String firstName = first_name_field.getText().toString().trim();
        String email = email_field.getText().toString().trim();
        String password = password_field.getText().toString().trim();
        String reEnterPassword = re_enter_password_field.getText().toString().trim();


        if (TextUtils.isEmpty(lastName)) {
            last_name_field.setHint("Last Name Cannot be Empty");
            last_name_field.setBackgroundResource(R.drawable.not_started_text_wrapper);
            last_name_field.setError("Last Name Cannot be Empty");
            return;
        }else if (lastName.length()<2) {
            last_name_field.setText("Password not equals to reenter password");
            last_name_field.setBackgroundResource(R.drawable.not_started_text_wrapper);
            return;
        }else if (!TextUtils.isEmpty(lastName)) {
            last_name_field.setBackgroundResource(R.drawable.succes_text_wrapper);
            last_name_field.getVisibility();

        }

        if (TextUtils.isEmpty(firstName)) {
            first_name_field.setText("Password not equals to reenter password");
            first_name_field.setBackgroundResource(R.drawable.not_started_text_wrapper);
            return;
        }
        if (TextUtils.isEmpty(email)) {
            email_field.setText("Password not equals to reenter password");
            email_field.setBackgroundResource(R.drawable.not_started_text_wrapper);
            return;
        }else if (!email.matches(email_patterns)) {
            email_field.setText("Password not equals to reenter password");
            email_field.setBackgroundResource(R.drawable.not_started_text_wrapper);
            return;
        }
        if (TextUtils.isEmpty(password)) {
            re_enter_password_field.setText("Password not equals to reenter password");
            re_enter_password_field.setBackgroundResource(R.drawable.not_started_text_wrapper);
            return;
        }else if(password.length() < 7 ) {
            password_field.setText("Password not equals to reenter password");
            password_field.setBackgroundResource(R.drawable.not_started_text_wrapper);
            return;
        }else if (!password.equals(reEnterPassword)) {
            password_field.setText("Password not equals to reenter password");
            password_field.setBackgroundResource(R.drawable.not_started_text_wrapper);
            return;
        }

        if (TextUtils.isEmpty(password)) {
            password_field.setText("Password not equals to reenter password");
            password_field.requestFocus();
            return;
        }
        authentication.createUserWithEmailAndPassword(email, password )
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            RegisteredUsers registerMentors = new RegisteredUsers();

                            FirebaseDatabase.getInstance().getReference("Mentors")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(registerMentors).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(MentorSignUP.this, "Registration Successful" , Toast.LENGTH_LONG).show();
                                                Intent goToCareerSelection = new Intent( MentorSignUP.this, CareerSelection.class);
                                                startActivity(goToCareerSelection);
                                                finish();
                                            }else {
                                                Toast.makeText(MentorSignUP.this, "Registration Failed " , Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }else {
                            Toast.makeText(MentorSignUP.this, "Registration Failed " , Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }


    public void listOfMentorCareerPopUp () {
        Resources resources = getResources();
        String[] list_of_mentors_career = resources.getStringArray(R.array.List_of_fields_available);
        ArrayAdapter<String> listOfCareers = new ArrayAdapter<String>(MentorSignUP.this, R.layout.mentor_field, list_of_mentors_career);
        autoCompleteTextView.setAdapter(listOfCareers);

    }
}