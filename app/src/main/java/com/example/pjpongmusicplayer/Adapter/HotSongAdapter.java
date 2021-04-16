package com.example.pjpongmusicplayer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pjpongmusicplayer.Model.Song;
import com.example.pjpongmusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HotSongAdapter extends RecyclerView.Adapter<HotSongAdapter.ViewHolder> {

    Context context;

    public HotSongAdapter(Context context, ArrayList<Song> songArrayList) {
        this.context = context;
        this.songArrayList = songArrayList;
    }

    ArrayList<Song> songArrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hot_song_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songArrayList.get(position);
        holder.tvsongsinger.setText(song.getSongArtist());
        holder.tvsongname.setText(song.getSongName());
        Picasso.get().load(song.getSongImage()).into(holder.imgsong);
    }

    @Override
    public int getItemCount() {
        return songArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvsongname,tvsongsinger;
        ImageView imgsong,imglikes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvsongsinger = itemView.findViewById(R.id.textviewhotsongsinger);
            tvsongname = itemView.findViewById(R.id.textviewhotsongname);
            imgsong = itemView.findViewById(R.id.imageviewhootsong);
            imglikes = itemView.findViewById(R.id.imageviewlikes);
        }
    }
}
