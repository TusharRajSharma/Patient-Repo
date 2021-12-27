package com.example.projectpatientrecordsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Patient_Login extends AppCompatActivity {

    TextInputLayout t1,t2;
    ProgressBar bar;
    Button loginbtn;
    FirebaseAuth mAuth;
    public String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        t1=(TextInputLayout)findViewById(R.id.email_login);
        t2=(TextInputLayout)findViewById(R.id.pwd_login);
        bar=(ProgressBar)findViewById(R.id.progressBar3_login);
        loginbtn =(Button)findViewById(R.id.loginbtn);
        mAuth = FirebaseAuth.getInstance();
    }

    public void signinhere(View view) {
        bar.setVisibility(View.VISIBLE);
        email=t1.getEditText().getText().toString();
        String password=t2.getEditText().getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(Patient_Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            bar.setVisibility(View.INVISIBLE);
                            Intent intent=new Intent(Patient_Login.this, AddPatientDetails.class);
                           /*
                            Intent intent=new Intent(LoginActivity.this, UserDatabase.class);
                            intent.putExtra("email",mAuth.getCurrentUser().getEmail());
                            intent.putExtra("uid",mAuth.getCurrentUser().getUid());
                            */
                            startActivity(intent);
                        } else
                        {
                            bar.setVisibility(View.INVISIBLE);
                            t1.getEditText().setText("");
                            t2.getEditText().setText("");
                            Toast.makeText(getApplicationContext(),"Invalid email/password",Toast.LENGTH_LONG).show();
                        }

                        // ...
                    }
                });

    }
}