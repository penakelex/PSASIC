package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

import java.util.Arrays;

public class UsersResponse extends Response {

    public String[] users;

    public UsersResponse(int code, String[] users, String message) {
        super(code, message);
        this.users = users;
    }

    @Override
    public String toString() {
        return this.code+" "+this.success+" "+this.message+" "+Arrays.toString(this.users);
    }
}
