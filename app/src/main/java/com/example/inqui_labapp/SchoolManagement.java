package com.example.inqui_labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class SchoolManagement extends AppCompatActivity {
    TextInputLayout schoolid, email, password, school;
    TextView username;
    Spinner ClassSM;
    String user_sid, user_username, user_email, user_pass, user_sname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_management);
        schoolid = findViewById(R.id.schoolidSM);
        email = findViewById(R.id.emailSM);
        password = findViewById(R.id.passwordSM);
        username = findViewById(R.id.userSM);
        school = findViewById(R.id.schoolSM);
        ClassSM = findViewById(R.id.classSM);
        List<String> categories2 = new ArrayList<String>();
        categories2.add("All");
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
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ClassSM.setAdapter(dataAdapter2);
        showAllUserData();
    }


    private void showAllUserData() {
        Intent intent = getIntent();
        user_sid = intent.getStringExtra("schoolid");
        user_sname = intent.getStringExtra("schoolname");
        user_username = intent.getStringExtra("username");
        user_email = intent.getStringExtra("email");
        user_pass = intent.getStringExtra("password");

        username.setText("Username: " + user_username);
        schoolid.getEditText().setText(user_sid);
        password.getEditText().setText(user_pass);
        email.getEditText().setText(user_email);
        school.getEditText().setText(user_sname);
    }
}