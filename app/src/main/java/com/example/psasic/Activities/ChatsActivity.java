package com.example.psasic.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.psasic.databinding.ActivityChatsBinding;

public class ChatsActivity extends AppCompatActivity {
    private ActivityChatsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}