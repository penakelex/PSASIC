package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

public class NewMessagesResponse extends Response {
    public String[] newMessages;

    public NewMessagesResponse(int code, String message, String[] newMessages) {
        super(code, message);
        this.newMessages = newMessages;
    }
}
