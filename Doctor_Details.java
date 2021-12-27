package com.example.projectpatientrecordsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Doctor_Details extends AppCompatActivity {

    EditText docname,docspec, docdeg, docexp, docEmail;
    EditText Age;
    ProgressBar bar;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("Doctor_Details");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        docname = (EditText) findViewById(R.id.docName);
        docspec = (EditText) findViewById(R.id.docSpecility);
        Age = (EditText) findViewById(R.id.docAge);
        docdeg = (EditText) findViewById(R.id.docDegree);
        docexp = (EditText) findViewById(R.id.docExp);
        docEmail = (EditText) findViewById(R.id.docEmail);
        bar = (ProgressBar)findViewById(R.id.progressBar);


    }

    public void SaveDoctorDetails(View view) {
        String getName = docname.getText().toString();
        String getSpec = docspec.getText().toString();
        int getAge = Age.getInputType();
        String getExp = docexp.getText().toString();
        String getDeg = docdeg.getText().toString();
        String get_email = docEmail.getText().toString();
        String getEmail = get_email.substring(0,get_email.indexOf('@'));


        HashMap<String,Object> hashmap = new HashMap<>();
        hashmap.put("Doctor Name",getName);
        hashmap.put("Doctor Specification",getSpec);
        hashmap.put(" Doctor Age",getAge);
        hashmap.put("Doctor Experience in Working Area",getExp);
        hashmap.put("Doctor's Degree",getDeg);

        databaseReference.child("Patient_Details").child(getEmail).setValue(hashmap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        docname.setText("");
                        docEmail.setText("");
                        Age.setText("");
                        docspec.setText("");
                        docexp.setText("");
                        docdeg.setText("");

                        Toast.makeText(Doctor_Details.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        docname.setText("");
                        docEmail.setText("");
                        Age.setText("");
                        docspec.setText("");
                        docexp.setText("");
                        docdeg.setText("");
                        Toast.makeText(Doctor_Details.this, "Failed To Execute", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}