package com.example.psasic.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.psasic.databinding.ActivityMessengerBinding;

public class MessengerActivity extends AppCompatActivity {
    private ActivityMessengerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessengerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}