package com.example.psasic.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.psasic.databinding.ActivityServerSelectBinding;
import com.example.psasic.server.RetrofitServiceLocal;
import com.example.psasic.server.local.responses.UsersResponse;
import com.example.psasic.server.local.service.LocalAPI;
import com.example.psasic.server.local.service.LocalService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerSelectActivity extends AppCompatActivity {
    private ActivityServerSelectBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityServerSelectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.arrowBack.setOnClickListener(v->onBackPressed());
        sharedPreferences = getSharedPreferences("loginData", Context.MODE_PRIVATE);

        binding.signinButton.setOnClickListener(v -> serverFirstRequest(binding.textServer.getText().toString()));
    }

    private void serverFirstRequest(String serverKey) {
        RetrofitServiceLocal.BASE_URL = "http://"+serverKey;
        Log.e("Опа ты посмотри", "serverFirstRequest "+RetrofitServiceLocal.BASE_URL);
        Log.e("А как тебе такое?", sharedPreferences.getString("entryKey", "null"));
        LocalService.getInstance().listUsers(sharedPreferences.getString("entryKey", "null")).enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(@NonNull Call<UsersResponse> call, @NonNull Response<UsersResponse> response) {
                if (response.body()!=null) {
                    Log.e("ПОКАЖИСЬ ЧЁРТ", "onResponse: "+response.body().toString());
                    response.body().update();
                    if (response.body().success) {
                        startActivity(new Intent(getApplicationContext(), MapActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Ошибка: "+response.body().message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Ошибка: сервер вернул null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<UsersResponse> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Ошибка: "+t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}