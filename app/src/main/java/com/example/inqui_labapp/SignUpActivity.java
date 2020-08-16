package com.example.inqui_labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {
    TextInputLayout regName, regEmail, regPassword, regSchool;
    Button reg, sign;
    Spinner signupspinner, classSpinner;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        regName = findViewById(R.id.Name);
        regEmail = findViewById(R.id.email);
        regPassword = findViewById(R.id.pass);
        regSchool = findViewById(R.id.SchoolName);
        reg = findViewById(R.id.lgn);
        sign = findViewById(R.id.signup);
        signupspinner = findViewById(R.id.Signup_spinner);
        classSpinner = findViewById(R.id.class_spinner);
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
        signupspinner.setAdapter(dataAdapter1);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(dataAdapter2);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }


    public void registerUser() {



            String name = regName.getEditText().getText().toString();
            String email = regEmail.getEditText().getText().toString();
            String password = regPassword.getEditText().getText().toString();
            String schoolName = regSchool.getEditText().getText().toString();
            String studentClass = classSpinner.getSelectedItem().toString();
            String authority = signupspinner.getSelectedItem().toString();
            StudentData userHelper = new StudentData(name, schoolName, studentClass, email, password, authority);
            reference = FirebaseDatabase.getInstance().getReference(authority);
            reference.child(name).setValue(userHelper);
            return;
        }
}
