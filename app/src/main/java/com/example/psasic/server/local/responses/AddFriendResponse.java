package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

public class AddFriendResponse extends Response {
    public int state;


    public AddFriendResponse(int status, int state, String message) {
        super(status, message);
        this.state = state;
    }
}
