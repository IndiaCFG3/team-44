package com.example.inqui_labapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

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
    TextInputLayout username, password;
    ImageView image;
    Spinner spinner_class, spinner_authority;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btlogin = findViewById(R.id.btnlogin);
        btsignup = findViewById(R.id.btnsignup);
        logon = findViewById(R.id.logo_name);
        slogan = findViewById(R.id.slogan);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.password);
        spinner_authority = findViewById(R.id.Admin_spinner);
        spinner_class = findViewById(R.id.spinner_class);
            List<String> categories1 = new ArrayList<String>();
            categories1.add("Student-Teacher");
            categories1.add("Teacher");
            categories1.add("School Management");
            categories1.add("Inquilab Associate");
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
        final String userEnteredUsername = username.getEditText().getText().toString().trim();
        final String userEnteredPassword = password.getEditText().getText().toString().trim();
        final String userEnteredAuthority = spinner_authority.getSelectedItem().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(userEnteredAuthority);
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    username.setError(null);
                    username.setErrorEnabled(false);
                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    String sidFromDB = dataSnapshot.child(userEnteredUsername).child("schoolid").getValue(String.class);
                    String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                    String schoolNameFromDB = dataSnapshot.child(userEnteredUsername).child("schoolname").getValue(String.class);
                    String classFromDB = dataSnapshot.child(userEnteredUsername).child("sclass").getValue(String.class);
                    String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                    String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)) {
                        username.setError(null);
                        username.setErrorEnabled(false);
                        if(userEnteredAuthority.equals("Student-Teacher")){

                            Intent intent = new Intent(getApplicationContext(), StudentTeacherDashboard.class);
                            intent.putExtra("name", nameFromDB);
                            intent.putExtra("schoolname", schoolNameFromDB);
                            intent.putExtra("schoolid", sidFromDB);
                            intent.putExtra("sclass", classFromDB);
                            intent.putExtra("password", passwordFromDB);
                            intent.putExtra("username", usernameFromDB);
                            startActivity(intent);
                        }
                        else if(userEnteredAuthority.equals("Teacher")){

                            Intent intent = new Intent(getApplicationContext(), TeacherDashboard.class);
                            intent.putExtra("name", nameFromDB);
                            intent.putExtra("schoolname", schoolNameFromDB);
                            intent.putExtra("schoolid", sidFromDB);
                            intent.putExtra("sclass", classFromDB);
                            intent.putExtra("username", usernameFromDB);
                            startActivity(intent);
                        }
                        else if(userEnteredAuthority.equals("School Management")){

                            Intent intent = new Intent(getApplicationContext(), SchoolManagement.class);
                            intent.putExtra("schoolname", schoolNameFromDB);
                            intent.putExtra("schoolid", sidFromDB);
                            intent.putExtra("email", emailFromDB);
                            intent.putExtra("password", passwordFromDB);
                            intent.putExtra("username", usernameFromDB);
                            startActivity(intent);
                        }else if(userEnteredAuthority.equals("Inquilab Associate")){

                            Intent intent = new Intent(getApplicationContext(), InquilabAssociate.class);
                            intent.putExtra("name", nameFromDB);
                            intent.putExtra("password", passwordFromDB);
                            intent.putExtra("username", usernameFromDB);
                            intent.putExtra("email", emailFromDB);
                            startActivity(intent);
                        }
                    } else {
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                } else {
                    username.setError("No such User exist");
                    username.requestFocus();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




}