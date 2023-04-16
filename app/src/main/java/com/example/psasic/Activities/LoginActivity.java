package com.example.psasic.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.psasic.databinding.ActivityLoginBinding;
import com.example.psasic.server.global.responses.AuthResponse;
import com.example.psasic.server.global.responses.SessionResponse;
import com.example.psasic.server.global.service.LoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
   private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String entryKey = sharedPreferences.getString("entryKey", null);

        if (entryKey!=null) {
            if (isSessionRequest(entryKey)) {
                startActivity(new Intent(this, MapActivity.class));
            }
        }

        binding.signinButton.setOnClickListener(v -> loginRequest(
                binding.username.getText().toString(),
                binding.textPassword.getText().toString()
        ));
        binding.createAcc.setOnClickListener(v->{
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

    }

    private void loginRequest(String username, String password) {
        LoginService.getInstance().login(username, password).enqueue(new Callback<AuthResponse>() {
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


    private boolean isSessionRequest(String entryKey) {
        final boolean[] result = new boolean[1];
        LoginService.getInstance().isSession(entryKey).enqueue(new Callback<SessionResponse>() {
            @Override
            public void onResponse(@NonNull Call<SessionResponse> call, @NonNull Response<SessionResponse> response) {
                if (response.body()==null) {
                    result[0] = response.body().state;
                } else {
                    Toast.makeText(getApplicationContext(), "Ошибка: сервер вернул null", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<SessionResponse> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Ошибка: "+t, Toast.LENGTH_SHORT).show();
            }
        });
        return result[0];
    }
}