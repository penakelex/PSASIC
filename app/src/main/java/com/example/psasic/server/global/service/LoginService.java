package com.example.psasic.server.global.service;

import com.example.psasic.server.RetrofitService;

public class LoginService {
    private static LoginAPI loginAPI;
    private static final String BASE_URL = RetrofitService.BASE_URL;

    private static LoginAPI create() {
        return RetrofitService.getInstance().create(LoginAPI.class);
    }

    public static LoginAPI getInstance() {
        if (loginAPI == null) loginAPI = create();
        return loginAPI;
    }
}
