package com.example.ktralan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView textContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textContext=findViewById(R.id.ten);
        Intent intent=this.getIntent();

        textContext.setText(intent.getStringExtra("ten"));
    }
}