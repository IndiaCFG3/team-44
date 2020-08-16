package com.example.inqui_labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class TeacherDashboard extends AppCompatActivity {
    TextInputLayout name, schoolID, school, sclass;
    TextView username;
    String user_name, user_username, user_pass, user_school, user_sclass, user_sid;
    Button ClassObForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);
        name = findViewById(R.id.nameT);
        schoolID = findViewById(R.id.schoolidT);
        school = findViewById(R.id.schoolT);
        sclass = findViewById(R.id.classnumT);
        username = findViewById(R.id.userT);
        ClassObForm = findViewById(R.id.classObvT);
        showAllUserData();


        ClassObForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherDashboard.this, ClassObserForm.class);
                startActivity(intent);
            }
        });
    }


    private void showAllUserData() {
        Intent intent = getIntent();
        user_name = intent.getStringExtra("name");
        user_username = intent.getStringExtra("username");
        user_school = intent.getStringExtra("schoolname");
        user_sclass = intent.getStringExtra("sclass");
        user_sid = intent.getStringExtra("schoolid");

        username.setText("Username: " + user_username);
        schoolID.getEditText().setText(user_sid);
        name.getEditText().setText(user_name);
        sclass.getEditText().setText(user_sclass);
        school.getEditText().setText(user_school);

    }
}