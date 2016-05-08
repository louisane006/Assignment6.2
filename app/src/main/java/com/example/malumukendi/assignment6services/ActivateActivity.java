package com.example.malumukendi.assignment6services;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivateActivity extends AppCompatActivity {
    private EditText email;
    private  EditText pass;
    private  EditText code;
    private Button activateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.action_settings);
        pass=(EditText) findViewById(R.id.action_settings);
        code=(EditText) findViewById(R.id.action_settings);
        activateButton = (Button) findViewById(R.id.action_settings);


        activateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Do something in response to button click
                Log.d("EMAIL",email.getText().toString());
                Log.d("PASS",pass.getText().toString());
                Log.d("CODE",code.getText().toString());
            }
        });
    }
}
