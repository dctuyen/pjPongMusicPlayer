package com.example.pjpongmusicplayer.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pjpongmusicplayer.Model.Categoryytheme;
import com.example.pjpongmusicplayer.R;
import com.example.pjpongmusicplayer.Service.APIService;
import com.example.pjpongmusicplayer.Service.Dataservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Theme_Category extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_theme_category_today,container,false);
        GetData();
        return view;

    }
//    Categoryytheme categoryytheme = response.body();
//                Log.d("BBBB",categoryytheme.getCategory().get(0).getCategoryName());
//    Log.d("chudevatl",t.getMessage());
    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Categoryytheme>> callback = dataservice.GetCategoryTheme();
        callback.enqueue(new Callback<List<Categoryytheme>>() {
            @Override
            public void onResponse(Call<List<Categoryytheme>> call, Response<List<Categoryytheme>> response) {
                Categoryytheme categoryytheme = (Categoryytheme) response.body();
                Log.d("BBBB",categoryytheme.getCategory().get(0).getCategoryName());
            }

            @Override
            public void onFailure(Call<List<Categoryytheme>> call, Throwable t) {
                Log.d("chudevatl",t.getMessage());
            }
        });

    }
}
