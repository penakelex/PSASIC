package com.example.psasic.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.psasic.databinding.ActivityRegisterBinding;
import com.example.psasic.server.global.responses.AuthResponse;
import com.example.psasic.server.global.service.LoginService;
import com.example.psasic.server.local.service.LocalService;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signupBtn.setOnClickListener(v -> registerRequest(
                binding.textName.getText().toString(),
                binding.textPassword.getText().toString(),
                binding.textConfirmPassword.getText().toString()
                ));
        binding.arrowBack.setOnClickListener(v-> onBackPressed());
    }

    private void registerRequest(String email, String username, String password) {
        LoginService.getInstance().register(username, password, email).enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(@NonNull Call<AuthResponse> call, @NonNull Response<AuthResponse> response) {
                if (response.body()!=null) {
                    startActivity(new Intent(getApplicationContext(), MapActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Ошибка: сервер вернул null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AuthResponse> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Ошибка: "+t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}