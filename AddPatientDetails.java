package com.example.projectpatientrecordsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddPatientDetails extends AppCompatActivity {

    EditText name, email,surname, parent;
    EditText Age;
    ProgressBar bar;
    RadioButton patgender;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("Patient_Details");
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_details);

        name = (EditText) findViewById(R.id.fullName);
        surname = (EditText) findViewById(R.id.surname);
        parent = (EditText) findViewById(R.id.parentName);
        Age = (EditText) findViewById(R.id.age);
        email = (EditText)findViewById(R.id.email);
        patgender = (RadioButton)findViewById(R.id.radioMale);
        bar = (ProgressBar)findViewById(R.id.progressBar);
    }

    public void SavePatientRecord(View view) {

        String getName = name.getText().toString();
        String get_email = email.getText().toString();
        String getEmail = get_email.substring(0,get_email.indexOf('@'));
        String getSurname = surname.getText().toString();
        String getParent = parent.getText().toString();

        int getAge = Age.getInputType();
        String getGender = patgender.getText().toString();
        if (patgender.isChecked())
            getGender = "Male";
        else
            getGender = "Female";

        HashMap<String,Object> hashmap = new HashMap<>();
        HashMap<String,Object> patient_hashmap = new HashMap<>();

        hashmap.put("Email",getEmail);
        hashmap.put("name",getName);
        hashmap.put("Surnamee",getSurname);
        hashmap.put("Parent",getParent);
        hashmap.put("Age",getAge);
        hashmap.put("Gender",getGender);
        hashmap.put("Patient_Detail",patient_hashmap);


        databaseReference.child("Patient_Details").child(getEmail).setValue(hashmap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        name.setText("");
                        email.setText("");
                        Age.setText("");
                        surname.setText("");
                        parent.setText("");

                        // password.setText("");
                        Toast.makeText(AddPatientDetails.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

//                        DatabaseReference reference = database.getReference("Patient_Details");
//
//                        String d = reference.orderByChild("name").toString();
//                        System.out.println(d);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        name.setText("");
                        email.setText("");
                        Age.setText("");
                        Toast.makeText(AddPatientDetails.this, "Failed To Execute", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void DeleteCurrPatient(View view) {
        /*
        Log.d(TAG, "DeleteCurrDoc()");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure to delete this Doctor?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked ok button
                //doctorDB.DeleteDoctor(mDoctor);
                MainActivity.this.onBackPressed();
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                MainActivity.this.onBackPressed();
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

         */
    }

    public void CancelPatientRecordEdit(View view) {
    }
}