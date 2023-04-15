package com.example.psasic.Servers;

public class UserItem {
    private String username; // название
    private String description;  // описание
    private String image;

    public UserItem(String name, String description){

        this.username=name;
        this.description=description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

