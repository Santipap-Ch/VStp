package com.example.projerct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity extends AppCompatActivity {
    private EditText emailUI, passwordUI;
    private Button signInBtn;
    private TextView signUpBtn;
    private FirebaseAuth mAuth;
    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mAuth = FirebaseAuth.getInstance();

        initialzeUI();

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signinAccount();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupAccount();
            }
        });

    }

    private void signinAccount(){
        String email, password;
        email = emailUI.getText().toString();
        password = passwordUI.getText().toString();
        mEmail = email;

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_SHORT).show();
            emailUI.setError("Please enter email");
            emailUI.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(), "Please enter password...", Toast.LENGTH_SHORT).show();
            passwordUI.setError("Please enter password");
            passwordUI.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Sign in successful", Toast.LENGTH_SHORT).show();
                    Intent listEvents = new Intent(AdminActivity.this, EventsListActivity.class);
                    listEvents.putExtra("email",mEmail);
                    startActivity(listEvents);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Sign in failed! Please try again later",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void signupAccount(){
        Intent signup = new Intent(AdminActivity.this,SignUpActivity.class);
        startActivity(signup);
    }

    private void initialzeUI(){
        emailUI = (EditText) findViewById(R.id.email);
        passwordUI = (EditText) findViewById(R.id.password);
        signInBtn = (Button) findViewById(R.id.signIn);
        signUpBtn = (TextView) findViewById(R.id.signUp);
    }
}
