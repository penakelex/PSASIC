package com.example.psasic.server.global.responses;

import com.example.psasic.server.Response;

public class AuthResponse extends Response {
    public String authKey;

    AuthResponse(int code, String authKey, String message) {
        super(code, message);
        this.authKey = authKey;
    }
}
