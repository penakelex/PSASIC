package com.example.psasic.server.global.responses;

import com.example.psasic.server.Response;

public class SessionResponse extends Response {
    public boolean state;

    public SessionResponse(int code, boolean state, String message) {
        super(code, message);
        this.state = state;
    }
}
