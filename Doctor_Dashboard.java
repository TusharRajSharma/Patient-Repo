package com.example.projectpatientrecordsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Doctor_Dashboard extends AppCompatActivity {

    Button docpatDetails,Profilebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dashboard);

        Profilebtn =(Button)findViewById(R.id.docProfile);
        docpatDetails = (Button)findViewById(R.id.docAddPatDetails);

    }

    public void addPatientDetails(View view) {
        startActivity(new Intent(Doctor_Dashboard.this,SearchPatient.class));
    }

    public void doctorProfile(View view) {
        startActivity(new Intent(Doctor_Dashboard.this,Doctor_Details.class));
    }
}