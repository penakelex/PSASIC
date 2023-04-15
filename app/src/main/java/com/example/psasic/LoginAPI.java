package com.example.psasic;

import org.json.JSONObject;

<<<<<<< HEAD
import okhttp3.ResponseBody;
import retrofit2.Call;
=======
import retrofit2.Call;
import retrofit2.Response;
>>>>>>> origin/main
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginAPI {

    @POST("/register")
    @FormUrlEncoded
<<<<<<< HEAD
    Call<ResponseBody> register(@Field("username") String username, @Field("password") String password );
=======
    Call<Response> register(@Field("username") String username, @Field("password") String password );
>>>>>>> origin/main
}
