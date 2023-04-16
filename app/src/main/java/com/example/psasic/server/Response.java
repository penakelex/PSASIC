package com.example.psasic.server;

public class Response {
    public int status;
    public boolean success;
    public String message;

    public Response(int status, String message) {
        this.status = status;
        this.success = (status==200);
        this.message = message;
    }
}
