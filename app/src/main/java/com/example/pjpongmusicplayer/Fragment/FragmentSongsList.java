package com.example.pjpongmusicplayer.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pjpongmusicplayer.Adapter.SongListAdapter;
import com.example.pjpongmusicplayer.Model.Songs;
import com.example.pjpongmusicplayer.R;
import com.example.pjpongmusicplayer.Service.APIService;
import com.example.pjpongmusicplayer.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSongsList extends Fragment {

    View view;
    //RecyclerView recyclerViewsonglist;
    //SongListAdapter songListAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_songs_list,container,false);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Songs>> callback = dataservice.GetSong();

        callback.enqueue(new Callback<List<Songs>>() {
            @Override
            public void onResponse(Call<List<Songs>> call, Response<List<Songs>> response) {
                ArrayList<Songs> songlist = (ArrayList<Songs>) response.body();
                Log.d("BB",songlist.get(0).getSongName());

//                songListAdapter = new SongListAdapter(getActivity(),songlist);
//                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//                recyclerViewsonglist.setLayoutManager(linearLayoutManager);
//                recyclerViewsonglist.setAdapter(songListAdapter);
            }

            @Override
            public void onFailure(Call<List<Songs>> call, Throwable t) {

            }
        });
    }
}
