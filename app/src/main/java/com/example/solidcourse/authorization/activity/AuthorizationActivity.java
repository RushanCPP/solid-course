package com.example.solidcourse.authorization.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.solidcourse.R;
import com.example.solidcourse.databinding.ActivityAuthorizationBinding;

public class AuthorizationActivity extends AppCompatActivity {
    ActivityAuthorizationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
    }
}