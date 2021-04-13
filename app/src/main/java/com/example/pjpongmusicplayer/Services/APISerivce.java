package com.example.pjpongmusicplayer.Services;

public class APISerivce {
    private static final String base_url = "https://webmusics.000webhostapp.com/server/";
    public static DataService getService(){
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
