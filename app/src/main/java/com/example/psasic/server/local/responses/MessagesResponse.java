package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

public class MessagesResponse extends Response {
    public String[][] messages;

    public MessagesResponse(int status, String message, String[][] messages) {
        super(status, message);
        this.messages = messages;
    }
}
