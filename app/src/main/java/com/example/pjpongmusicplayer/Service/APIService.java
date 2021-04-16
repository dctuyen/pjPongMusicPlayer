package com.example.pjpongmusicplayer.Service;

public class APIService {
    private static final String base_url = "https://webmusics.000webhostapp.com/server/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
