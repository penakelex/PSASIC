package com.example.psasic.server.global.service;

import com.example.psasic.server.Response;
import com.example.psasic.server.global.responses.AuthResponse;
import com.example.psasic.server.global.responses.SessionResponse;
import com.example.psasic.server.global.responses.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginAPI {

    @POST("/register")
    @FormUrlEncoded
    Call<AuthResponse> register(@Field("username") String username, @Field("password") String password, @Field("email") String email);

    @POST("/isSession")
    @FormUrlEncoded
    Call<SessionResponse> isSession(@Field("authKey") String authKey);

    @POST("/login")
    @FormUrlEncoded
    Call<AuthResponse> login(@Field("username") String username, @Field("password") String password);

    @POST("/quit")
    @FormUrlEncoded
    Call<Response> quit(@Field("authKey") String authKey);

    @POST("/about")
    @FormUrlEncoded
    Call<UserResponse> about(@Field("authKey") String authKey, @Field("username") String username);
}
