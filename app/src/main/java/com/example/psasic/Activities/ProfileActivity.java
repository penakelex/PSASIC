package com.example.psasic.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.psasic.databinding.ActivityProfileBinding;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private boolean isPhotos = true;
    private int column = 1;
    private ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.back.setOnClickListener(listener -> onBackPressed());
        binding.edit.setOnClickListener(listener -> editing());
        binding.photos.setOnClickListener(listener -> settingPhotos());
        binding.videos.setOnClickListener(listener -> settingVideos());
    }

    private void settingVideos() {
        if (isPhotos) {
            isPhotos = false;
            binding.image1.setVisibility(View.INVISIBLE);
            binding.image2.setVisibility(View.INVISIBLE);
            binding.image3.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Теперь Вы просматриваете видео", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Вы уже просматриваете видео", Toast.LENGTH_SHORT).show();
        }
    }


    private void settingPhotos() {
        if (isPhotos) {
            Toast.makeText(this, "Вы уже просматриваете фотографии", Toast.LENGTH_SHORT).show();
        } else {
            isPhotos = true;
            Toast.makeText(this, "Теперь Вы просматриваете фотографии", Toast.LENGTH_SHORT).show();
        }
    }

    private void editing() {
        Toast.makeText(this, "Вы не можете редактировать этот профиль!", Toast.LENGTH_SHORT).show();
    }
}