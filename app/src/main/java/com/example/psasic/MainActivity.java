package com.example.psasic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.psasic.databinding.ActivityMainBinding;
import com.example.psasic.server.global.responses.AuthResponse;
import com.example.psasic.server.global.service.LoginService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String entryKey = sharedPreferences.getString("entryKey", null);

        sharedPreferences.edit().putString("entryKey", null);*/

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LoginService.getInstance().register("Ну давай", "ответь мне", "яжду@очеть.чтоббезбагов").enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(@NonNull Call<AuthResponse> call, @NonNull Response<AuthResponse> response) {
                if (response.body()!=null) {
                    Log.e("GLOBAL_SERVER", "onResponse: "+response.body().authKey);
                } else {
                    Log.e("GLOBAL_SERVER", "onResponse: fuck this null");
                }
            }

            @Override
            public void onFailure(@NonNull Call<AuthResponse> call, @NonNull Throwable t) {
                Log.e("GLOBAL_SERVER", "onFailure: "+t);
            }
        });
    }
}