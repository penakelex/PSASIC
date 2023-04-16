package com.example.psasic.server.global.responses;

import com.example.psasic.server.Response;

public class AuthResponse extends Response {
    public String authKey;

    AuthResponse(int status, String authKey, String message) {
        super(status, message);
        this.authKey = authKey;
    }
}
