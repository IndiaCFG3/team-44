package com.example.inqui_labapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ClassObserForm extends AppCompatActivity {
    EditText editTextName,editTextClassPresence,editTextInitiative,editTextConfnfidence,editTextPreparation,editTextHelpingTeams;
    Button buttonAddItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_obser_form);
        editTextName = (EditText)findViewById(R.id.etName);
        editTextClassPresence = (EditText)findViewById(R.id.t1);
        editTextInitiative = (EditText)findViewById(R.id.t2);
        editTextConfnfidence = (EditText)findViewById(R.id.t3);
        editTextPreparation = (EditText)findViewById(R.id.t4);
        editTextHelpingTeams=(EditText)findViewById(R.id.t5);

        buttonAddItem = (Button)findViewById(R.id.submit);
        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItemToSheet();
            }
        });
    }

    private void   addItemToSheet() {

        final ProgressDialog loading = ProgressDialog.show(this,"Adding Item","Please wait");
        final String name = editTextName.getText().toString().trim();
        final String classPresence = editTextClassPresence.getText().toString().trim();
        final String intiative = editTextInitiative.getText().toString().trim();
        final String confidence = editTextConfnfidence.getText().toString().trim();
        final String preparation = editTextPreparation.getText().toString().trim();
        final String helpingTeams = editTextHelpingTeams.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbwGfCNXZ4eJnLnn07ZqahN3b8gHBWz8VjQ5EjjDhRr9NIlJHi4/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Toast.makeText(ClassObserForm.this,response,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<>();

                //here we pass params
                parmas.put("action","addObservation");
                parmas.put("name",name);
                parmas.put("classPresence",classPresence);
                parmas.put("intiative",intiative);
                parmas.put("confidence",confidence);
                parmas.put("preparation",preparation);
                parmas.put("helpingTeams",helpingTeams);
                return parmas;
            }
        };

        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);


    }



    public void onClick(View v) {

        if(v==buttonAddItem){
            addItemToSheet();

            //Define what to do when button is clicked
        }
    }

}