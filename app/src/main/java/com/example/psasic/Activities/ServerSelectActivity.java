package com.example.psasic.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.psasic.databinding.ActivityServerSelectBinding;
import com.example.psasic.server.local.service.LocalService;

public class ServerSelectActivity extends AppCompatActivity {
    private ActivityServerSelectBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityServerSelectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.arrowBack.setOnClickListener(v->onBackPressed());
        binding.signinButton.setOnClickListener(v -> serverFirstRequest());
    }

    private void serverFirstRequest() {
    }
}