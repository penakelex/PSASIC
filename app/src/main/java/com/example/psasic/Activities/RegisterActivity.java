package com.example.psasic.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.psasic.databinding.ActivityProfileBinding;
import com.example.psasic.databinding.ActivityRegisterBinding;
import com.example.psasic.server.global.responses.AuthResponse;
import com.example.psasic.server.global.service.LoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("loginData", Context.MODE_PRIVATE);

        binding.signupBtn.setOnClickListener(v -> registerRequest(
                binding.textName.getText().toString(),
                binding.textInputPassword.getText().toString(),
                binding.inputEmail.getText().toString()
                ));
        binding.arrowBack.setOnClickListener(v-> onBackPressed());
    }

    private void registerRequest(String email, String username, String password) {
        LoginService.getInstance().register(username, password, email).enqueue(new Callback<AuthResponse>() {

            @SuppressLint("CommitPrefEdits")
            @Override
            public void onResponse(@NonNull Call<AuthResponse> call, @NonNull Response<AuthResponse> response) {
                if (response.body()!=null) {
                    response.body().update();
                    if (response.body().success) {
                        sharedPreferences.edit().putString("entryKey", response.body().authKey).apply();
                        startActivity(new Intent(getApplicationContext(), ServerSelectActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Ошибка: "+response.body().message, Toast.LENGTH_SHORT).show();
                    }
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