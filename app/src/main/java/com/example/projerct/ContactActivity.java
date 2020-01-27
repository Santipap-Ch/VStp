package com.example.projerct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ContactActivity extends AppCompatActivity {
    private ImageView sendBtn;
    private EditText yourName, yourEmail, yourSubject, youMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        initializeUI();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = yourName.getText().toString();
                String email = yourEmail.getText().toString();
                String subject = yourSubject.getText().toString();
                String message = youMessage.getText().toString();

                if (TextUtils.isEmpty(name)){
                    yourName.setError("Enter Your Name");
                    yourName.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(subject)){
                    yourSubject.setError("Enter Your Name");
                    yourSubject.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(message)){
                    youMessage.setError("Enter Your Name");
                    youMessage.requestFocus();
                    return;
                }

                Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);

                sendEmail.setType("plane/text");
                sendEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"santepap.chairee@gmail.com"});
                sendEmail.putExtra(Intent.EXTRA_SUBJECT,subject);
                sendEmail.putExtra(Intent.EXTRA_TEXT,
                        "name: "+name+'\n'+"Email ID: "+email+'\n'+"Message:"+'\n'+message);

                startActivity(Intent.createChooser(sendEmail,"Send email..."));
            }
        });
    }

    private void initializeUI(){
        sendBtn = (ImageView) findViewById(R.id.send);
        yourName = (EditText) findViewById(R.id.yourName);
        yourEmail = (EditText) findViewById(R.id.yourEmail);
        yourSubject = (EditText) findViewById(R.id.yourSubject);
        youMessage = (EditText) findViewById(R.id.yourMessage);
    }
}
