package com.example.psasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.psasic.databinding.ActivityFriendsBinding;
import com.example.psasic.databinding.ActivityMainBinding;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LoginService.getInstance().register("БЛЯТЬ", "РАБОТАЙ СУКА").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                Log.d("TAG", "onResponse: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("TAG", "onFailure: "+t);
            }
        });
    }
}