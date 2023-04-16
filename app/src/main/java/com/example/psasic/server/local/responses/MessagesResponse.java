package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

public class MessagesResponse extends Response {
    public String[][] messages;

    public MessagesResponse(int code, String message, String[][] messages) {
        super(code, message);
        this.messages = messages;
    }
}
