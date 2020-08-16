package com.example.inqui_labapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    TextView logon, slogan;
    Button btlogin, btsignup;
    TextInputLayout name, password;
    ImageView image;
    Spinner spinner_class, spinner_authority;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btlogin = findViewById(R.id.btnlogin);
        btsignup = findViewById(R.id.btnsignup);
        image = findViewById(R.id.img_2);
        logon = findViewById(R.id.logo_name);
        slogan = findViewById(R.id.slogan);
        name = findViewById(R.id.Name);
        password = findViewById(R.id.password);
        spinner_authority = findViewById(R.id.Admin_spinner);
        spinner_class = findViewById(R.id.spinner_class);
            List<String> categories1 = new ArrayList<String>();
            categories1.add("Student-Teacher");
            categories1.add("Teacher");
            categories1.add("School Management");
            List<String> categories2 = new ArrayList<String>();
            categories2.add("7th");
            categories2.add("8th");
            categories2.add("9th");
            ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);
            dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_authority.setAdapter(dataAdapter1);

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_class.setAdapter(dataAdapter2);


        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isUser();
            }
        });


        btsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    private void isUser() {
        final String userEnteredEmail = name.getEditText().getText().toString().trim();
        final String userEnteredPassword = password.getEditText().getText().toString().trim();
        final String userEnteredAuthority = spinner_authority.getSelectedItem().toString();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(userEnteredAuthority);
        Query checkUser = reference.orderByChild("name").equalTo(userEnteredEmail);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    name.setError(null);
                    name.setErrorEnabled(false);
                    String passwordFromDB = dataSnapshot.child(userEnteredEmail).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)) {
                        name.setError(null);
                        name.setErrorEnabled(false);

                        Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                        startActivity(intent);
                    } else {
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                } else {
                    name.setError("No such User exist");
                    name.requestFocus();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




}