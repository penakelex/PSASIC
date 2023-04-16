package com.example.psasic.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.psasic.R;
import com.example.psasic.databinding.ActivityCameraBinding;

public class CameraActivity extends AppCompatActivity {
    private ActivityCameraBinding binding;
    private boolean isPhoto = true, isRecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCameraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.take.setOnClickListener(listener -> takingView());
        binding.photo.setOnClickListener(listener -> photo());
        binding.video.setOnClickListener(listener -> video());
    }

    private void video() {
        if (isRecording) {
            Toast.makeText(this, "Вы уже можете снимать видео", Toast.LENGTH_SHORT).show();
        } else {
            isRecording = true;
            Toast.makeText(this, "Вы можете снимать видео", Toast.LENGTH_SHORT).show();
        }
    }

    private void photo() {
        if (!isPhoto) {
            isPhoto = true;
            Toast.makeText(this, "Вы можете фотографировать", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Вы уже можете фотографировать", Toast.LENGTH_SHORT).show();
        }
    }

    private void takingView() {
        if (isPhoto) {
            Toast.makeText(this, "Сфотографировано!", Toast.LENGTH_SHORT).show();
        } else {
            if (isRecording) {
                isRecording = false;
                Toast.makeText(this, "Запись начата!", Toast.LENGTH_SHORT).show();
            } else {
                isRecording = true;
                Toast.makeText(this, "Запись закончена!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}