package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

public class AddFriendResponse extends Response {
    public int state;


    public AddFriendResponse(int code, int state, String message) {
        super(code, message);
        this.state = state;
    }
}
