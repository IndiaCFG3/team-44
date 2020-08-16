package com.example.inqui_labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class StudentTeacherDashboard extends AppCompatActivity {
    TextInputLayout name, password, schoolid, school, sclass;
    TextView username;
    String user_name, user_username,user_pass, user_school, user_sclass, user_sid;
    Button UEform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        name = findViewById(R.id.nameST);
        password = findViewById(R.id.passST);
        schoolid = findViewById(R.id.schoolidST);
        school = findViewById(R.id.schoolTS);
        sclass = findViewById(R.id.classnumTS);
        username = findViewById(R.id.userST);
        UEform = findViewById(R.id.unitevalST);
        showAllUserData();

        UEform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentTeacherDashboard.this,  UnitEvalForm.class);
                startActivity(intent);
            }
        });
    }



    private void showAllUserData() {
        Intent intent = getIntent();
        user_name = intent.getStringExtra("name");
        user_username = intent.getStringExtra("username");
        user_pass = intent.getStringExtra("password");
        user_school = intent.getStringExtra("schoolname");
        user_sclass = intent.getStringExtra("sclass");
        user_sid = intent.getStringExtra("schoolid");

        username.setText("Username: " + user_username);
        schoolid.getEditText().setText(user_sid);
        password.getEditText().setText(user_pass);
        name.getEditText().setText(user_name);
        sclass.getEditText().setText(user_sclass);
        school.getEditText().setText(user_school);

    }
}