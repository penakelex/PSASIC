package com.example.psasic.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.psasic.databinding.ActivitySettingsActivivyBinding;

public class SettingsActivity extends AppCompatActivity {
    private ActivitySettingsActivivyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsActivivyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.arrowBack.setOnClickListener(v->onBackPressed());
        binding.keyServer.setOnClickListener(v->{
            Intent intent = new Intent(SettingsActivity.this, ServerSelectActivity.class);
            startActivity(intent);
        });
    }
}