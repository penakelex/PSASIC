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
}
