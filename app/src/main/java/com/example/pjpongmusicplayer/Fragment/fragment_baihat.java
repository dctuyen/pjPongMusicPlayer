package com.example.pjpongmusicplayer.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pjpongmusicplayer.Models.Baihat;
import com.example.pjpongmusicplayer.R;
import com.example.pjpongmusicplayer.Services.APIService;
import com.example.pjpongmusicplayer.Services.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_baihat extends Fragment {

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_baihat,container,false);
        //GetData();
        return view;
    }

//    private void GetData() {
//        Dataservice dataservice = APIService.getService();
//        Call<List<Baihat>> callback = dataservice.GetBaiHat();
//        callback.enqueue(new Callback<List<Baihat>>() {
//            @Override
//            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
//                ArrayList<Baihat> baihatArrayList = (ArrayList<Baihat>) response.body();
//                Log.d("BBB",baihatArrayList.get(0).getSongArtist());
//            }
//
//            @Override
//            public void onFailure(Call<List<Baihat>> call, Throwable t) {
//
//            }
//        });
//    }
}
