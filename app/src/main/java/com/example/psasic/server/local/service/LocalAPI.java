package com.example.psasic.server.local.service;

import com.example.psasic.server.Response;
import com.example.psasic.server.local.responses.AddFriendResponse;
import com.example.psasic.server.local.responses.FriendsResponse;
import com.example.psasic.server.local.responses.GeoResponse;
import com.example.psasic.server.local.responses.MessagesResponse;
import com.example.psasic.server.local.responses.NewMessagesResponse;
import com.example.psasic.server.local.responses.SendResponse;
import com.example.psasic.server.local.responses.UsersResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LocalAPI {

    @POST("/listUsers")
    @FormUrlEncoded
    Call<UsersResponse> listUsers(@Field("authKey") String authKey);

    @POST("/addFriend")
    @FormUrlEncoded
    Call<AddFriendResponse> addFriend(@Field("authKey") String authKey,
                                      @Field("username") String username);

    @POST("/removeFriend")
    @FormUrlEncoded
    Call<Response> removeFriend(@Field("authKey") String authKey,
                                @Field("username") String username);

    @POST("/friends")
    @FormUrlEncoded
    Call<FriendsResponse> quit(@Field("authKey") String authKey);

    @POST("/setGeo")
    @FormUrlEncoded
    Call<Response> about(@Field("authKey") String authKey,
                            @Field("altitude") double altitude,
                            @Field("longitude ") double longitude);

    @POST("/getGeo")
    @FormUrlEncoded
    Call<GeoResponse> getGeo(@Field("authKey") String authKey,
                              @Field("username") String username);

    @POST("/sendMessage")
    @FormUrlEncoded
    Call<SendResponse> sendMessage(@Field("authKey") String authKey,
                                   @Field("username") String username,
                                   @Field("message") String message);

    @POST("/getMessages")
    @FormUrlEncoded
    Call<MessagesResponse> getMessages(@Field("authKey") String authKey,
                                       @Field("username") String username,
                                       @Field("page") int page);

    @POST("/newMessages")
    @FormUrlEncoded
    Call<NewMessagesResponse> newMessages(@Field("authKey") String authKey);

    @POST("/addToBlackList")
    @FormUrlEncoded
    Call<Response> addToBlackList(@Field("authKey") String authKey,
                                   @Field("username") String username);
}
