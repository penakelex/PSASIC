package com.example.psasic.server.local.responses;

import com.example.psasic.server.Response;

public class GeoResponse extends Response {
    public double altitude;
    public double longitude;


    public GeoResponse(int code, double altitude, double longitude, String message) {
        super(code, message);
        this.altitude = altitude;
        this.longitude = longitude;
    }
}
