package com.example.psasic;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginAPI {

    @POST("/register")
    @FormUrlEncoded
    Call<ResponseBody> register(@Field("username") String username, @Field("password") String password );
}
