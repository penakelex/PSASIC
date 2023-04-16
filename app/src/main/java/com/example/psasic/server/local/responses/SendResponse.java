package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

public class SendResponse extends Response {
    public String newMessage;

    public SendResponse(int code, String message, String newMessage) {
        super(code, message);
        this.newMessage = newMessage;
    }
}
