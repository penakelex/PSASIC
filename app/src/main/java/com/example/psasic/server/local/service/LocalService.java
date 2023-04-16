package com.example.psasic.server.local.service;

import com.example.psasic.server.RetrofitServiceLocal;

public class LocalService {
    private static LocalAPI localAPI;

    private static LocalAPI create() {
        return RetrofitServiceLocal.getInstance().create(LocalAPI.class);
    }

    public static LocalAPI getInstance() {
        if (localAPI == null) localAPI = create();
        return localAPI;
    }
}
