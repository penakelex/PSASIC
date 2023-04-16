package com.example.psasic.server.local.service;

import com.example.psasic.server.RetrofitService;

public class LocalService {
    private static LocalAPI loginAPI;
    private static final String BASE_URL = RetrofitService.BASE_URL;

    private static LocalAPI create() {
        return RetrofitService.getInstance().create(LocalAPI.class);
    }

    public static LocalAPI getInstance() {
        if (loginAPI == null) loginAPI = create();
        return loginAPI;
    }
}
