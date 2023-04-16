package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

public class UsersResponse extends Response {

    String[] userItems;

    public UsersResponse(int status, String[] userItems, String message) {
        super(status, message);
        this.userItems = userItems;
    }
}
