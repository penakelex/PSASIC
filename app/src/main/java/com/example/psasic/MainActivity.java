package com.example.psasic;

<<<<<<< HEAD
import androidx.annotation.NonNull;
=======
>>>>>>> origin/main
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.psasic.databinding.ActivityFriendsBinding;
import com.example.psasic.databinding.ActivityMainBinding;

import org.json.JSONObject;

<<<<<<< HEAD
import okhttp3.ResponseBody;
=======
>>>>>>> origin/main
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

<<<<<<< HEAD
        LoginService.getInstance().register("БЛЯТЬ", "РАБОТАЙ СУКА").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                Log.e("TAG", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure: "+t);
=======
        LoginService.getInstance().register("БЛЯТЬ", "РАБОТАЙ СУКА").enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                Log.d("TAG", "onResponse: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("TAG", "onFailure: "+t);
>>>>>>> origin/main
            }
        });
    }
}