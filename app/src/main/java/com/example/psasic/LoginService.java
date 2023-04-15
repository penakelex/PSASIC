package com.example.psasic;

import android.util.Log;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService {
    private static LoginAPI loginAPI;
    private static final String BASE_URL = "http://25.35.68.71";

    private static LoginAPI create() {
        return RetrofitService.getInstance().create(LoginAPI.class);
    }

    public static LoginAPI getInstance() {
        if (loginAPI == null) loginAPI = create();
        return loginAPI;
    }

    public void register(String userName, String password) {
        LoginService.getInstance().register(userName, password).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(@NonNull Call<Response> call, @NonNull Response<Response> response) {
                assert response.body() != null;
                Log.d("TAG", "onResponse: " + response.body().toString());
            }

            @Override
            public void onFailure(@NonNull Call<Response> call, @NonNull Throwable t) {
                Log.d("TAG", "onFailure: " + t);
            }
        });
    }
}
