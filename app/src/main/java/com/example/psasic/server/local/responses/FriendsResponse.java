package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

public class FriendsResponse extends Response {
    String[] friends;


    public FriendsResponse(int status, String[] friends, String message) {
        super(status, message);
        this.friends = friends;
    }
}
