package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

public class FriendsResponse extends Response {
    public String[] friends;


    public FriendsResponse(int code, String[] friends, String message) {
        super(code, message);
        this.friends = friends;
    }
}
