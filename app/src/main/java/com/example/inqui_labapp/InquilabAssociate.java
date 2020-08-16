package com.example.inqui_labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class InquilabAssociate extends AppCompatActivity {
    TextInputLayout name, email, password, link;
    TextView username;
    String user_name, user_username, user_email, user_pass;
    Spinner SchoolAI, ClassAI;
    Button ClassObform;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquilab_associate);
        name = findViewById(R.id.nameAI);
        email = findViewById(R.id.emailAI);
        password = findViewById(R.id.passwordAI);
        username = findViewById(R.id.userAI);
        SchoolAI = findViewById(R.id.schoolAI);
        ClassAI = findViewById(R.id.classAI);
        ClassObform = findViewById(R.id.clsobAI);
        List<String> categories1 = new ArrayList<String>();
        categories1.add("School A");
        categories1.add("School B");
        categories1.add("School C");
        List<String> categories2 = new ArrayList<String>();
        categories2.add("7A");
        categories2.add("7B");
        categories2.add("7C");
        categories2.add("7D");
        categories2.add("8A");
        categories2.add("8B");
        categories2.add("8C");
        categories2.add("8D");
        categories2.add("9A");
        categories2.add("9B");
        categories2.add("9C");
        categories2.add("9D");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SchoolAI.setAdapter(dataAdapter1);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassAI.setAdapter(dataAdapter2);
        showAllUserData();


        ClassObform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InquilabAssociate.this, ClassObserForm.class);
                startActivity(intent);
            }
        });
    }


    private void showAllUserData() {
        Intent intent = getIntent();
        user_name = intent.getStringExtra("name");
        user_username = intent.getStringExtra("username");
        user_email = intent.getStringExtra("email");
        user_pass = intent.getStringExtra("password");

        username.setText("Username: " + user_username);
        name.getEditText().setText(user_name);
        password.getEditText().setText(user_pass);
        email.getEditText().setText(user_email);
    }
}