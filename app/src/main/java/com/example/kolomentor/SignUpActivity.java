package com.example.kolomentor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.net.Authenticator;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private EditText last_name_field, first_name_field, email_field, password_field, re_enter_password_field;
    private Button sign_up_button;
    private TextView login_text;
    public FirebaseAuth authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.sign_up);

        sign_up_button = findViewById(R.id.sign_up_button_id);
        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp ();
            }
        });
    }







    public void signUp () {

        String  email_patterns =  "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        last_name_field = findViewById(R.id.last_name_id);
        first_name_field = findViewById(R.id.first_name_id);
        email_field = findViewById(R.id.email_id);
        password_field = findViewById(R.id.password_id);
        re_enter_password_field = findViewById(R.id.re_enter_password_id);

        login_text = findViewById(R.id.login_text_id);

        //authentication = FirebaseAuth.getInstance();

        String lastName = last_name_field.getText().toString().trim();
        String firstName = first_name_field.getText().toString().trim();
        String email = email_field.getText().toString().trim();
        String password = password_field.getText().toString().trim();
        String reEnterPassword = re_enter_password_field.getText().toString().trim();


        if (TextUtils.isEmpty(lastName)) {
            last_name_field.setError("Last Name Cannot Be Empty");
            last_name_field.requestFocus();
        }else if (lastName.length()<2) {
            last_name_field.setError("Last name cannot be lesser than 2 characters");
            last_name_field.requestFocus();
        }

        if (TextUtils.isEmpty(firstName)) {
            first_name_field.setError("First Name Cannot Be Empty");
            first_name_field.requestFocus();
        }
        if (TextUtils.isEmpty(email)) {
            email_field.setError("Email Cannot be Empty");
            email_field.requestFocus();
        }else if (!email.matches(email_patterns)) {
            email_field.setError("Please provide a valid email");
        }
        if (TextUtils.isEmpty(password)) {
            re_enter_password_field.setError("Please confirm your password ");
            re_enter_password_field.requestFocus();
        }else if(password.length() < 7 ) {
            password_field.setError("Password is less than 7");
            password_field.requestFocus();
        }else if (!password.equals(reEnterPassword)) {
            password_field.setError("password not match with confirm Password");
            password_field.requestFocus();
        }

        if (TextUtils.isEmpty(password)) {
            password_field.setError("Password Cannot be Empty");
            password_field.requestFocus();
        }


        authentication.createUserWithEmailAndPassword(email, password )
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    RegisteredUsers registerusers = new RegisteredUsers();

                    FirebaseDatabase.getInstance().getReference("KolomentorRegistrants")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(registerusers).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignUpActivity.this, "Registration Successful" , Toast.LENGTH_LONG).show();
                                        Intent goToListOfMentor = new Intent();
                                        startActivity(goToListOfMentor);
                                    }else {
                                        Toast.makeText(SignUpActivity.this, "Registration Failed " , Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }else {
                    Toast.makeText(SignUpActivity.this, "Registration Failed " , Toast.LENGTH_LONG).show();
                }
            }
        });


    }



}