package com.example.psasic.server.global.responses;

import com.example.psasic.server.Response;

public class UserResponse extends Response {
    public String username;
    public String name;
    public String surname;
    public String dateOfBirth;
    public String icon;

    public UserResponse(int code, String username, String name, String surname, String dateOfBirth, String icon, String message) {
        super(code, message);
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.icon = icon;
    }
}
