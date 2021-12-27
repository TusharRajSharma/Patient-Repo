package com.example.projectpatientrecordsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchPatient extends AppCompatActivity {

//    EditText name;
//    Button searchbtn;
//    String l;
//    FirebaseDatabase ref = FirebaseDatabase.getInstance();
//    DatabaseReference databaseReference = ref.getReference("Patient_Details");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);
//
//        name = (EditText) findViewById(R.id.searh_id);
//        l = name.getText().toString();
    }

    public void searchPatient(View view) {
//        databaseReference  = ref.getReference("Patient_Details");
//        String str = databaseReference.orderByChild("Email").toString();
//        name.setText(str);




    }
}