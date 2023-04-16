package com.example.psasic.server;

public class Response {
    public int code;
    public boolean success;
    public String message;

    public Response(int code, String message) {
        this.code = code;
        this.success = (code==200);
        this.message = message;
    }

    public void update() {
        this.success = (code==200);
    }

    public String toString() {
        return this.code+" "+this.success+" "+this.message;
    }
}
