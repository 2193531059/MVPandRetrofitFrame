package com.example.administrator.mvphero.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.mvphero.R;

public class MainActivity extends AppCompatActivity{
    private TextView username;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name = getIntent().getStringExtra("username");
        username = findViewById(R.id.username);
        username.setText(name);
    }
}
