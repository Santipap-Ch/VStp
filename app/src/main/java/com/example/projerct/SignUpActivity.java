package com.example.projerct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private EditText emailUI, passwordUI, confirmpasswordUI;
    private Button signup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        initializeUI();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password, confirmpassword;
                email = emailUI.getText().toString();
                password = passwordUI.getText().toString();
                confirmpassword = confirmpasswordUI.getText().toString();
                
                if(TextUtils.isEmpty(email)){
                    emailUI.setError("Please enter email");
                    emailUI.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    passwordUI.setError("Please enter password");
                    passwordUI.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(confirmpassword)){
                    confirmpasswordUI.setError("Please enter confirmation password");
                    confirmpasswordUI.requestFocus();
                    return;
                }
                if(!password.equals(confirmpassword)) {
                    confirmpasswordUI.setError("Password do not match");
                    Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_LONG).show();
                    return;
                }



                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                            Intent admin = new Intent(SignUpActivity.this,AdminActivity.class);
                            startActivity(admin);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Registration failed! Please try again later",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    private void initializeUI(){
        emailUI = (EditText) findViewById(R.id.email);
        passwordUI= (EditText) findViewById(R.id.password);
        confirmpasswordUI = (EditText) findViewById(R.id.confirmpassword);
        signup = (Button) findViewById(R.id.signUp);
    }
}
