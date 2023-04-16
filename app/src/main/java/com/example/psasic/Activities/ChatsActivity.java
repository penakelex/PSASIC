package com.example.psasic.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.psasic.databinding.ActivityChatsBinding;
import com.example.psasic.databinding.ActivityFriendsBinding;

public class ChatsActivity extends AppCompatActivity {
    private ActivityChatsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}