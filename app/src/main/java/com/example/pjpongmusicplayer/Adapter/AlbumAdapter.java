package com.example.pjpongmusicplayer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pjpongmusicplayer.Model.Album;
import com.example.pjpongmusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    Context context;
    ArrayList<Album> arrayalbum;

    public AlbumAdapter(Context context, ArrayList<Album> arrayalbum) {
        this.context = context;
        this.arrayalbum = arrayalbum;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.album_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album =arrayalbum.get(position);
        holder.tvalbumsinger.setText(album.getAlbumSinger());
        holder.tvtvalbumname.setText(album.getAlbumName());
        Picasso.get().load(album.getAlbumImage()).into(holder.imgalbumimage);
    }

    @Override
    public int getItemCount() {
        return arrayalbum.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgalbumimage;
        TextView tvalbumsinger,tvtvalbumname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgalbumimage = itemView.findViewById(R.id.imageviewalbum);
            tvalbumsinger = itemView.findViewById(R.id.textviewalbumsinger);
            tvtvalbumname = itemView.findViewById(R.id.textviewalbumname);

        }
    }
}
