package com.example.pjpongmusicplayer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pjpongmusicplayer.Models.Playlist;
import com.example.pjpongmusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }

    class ViewHolder{
        TextView tvplaylistname;
        ImageView imgbackground,imgplaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder = null;
        if(convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.playlist_row,null);
            viewHolder = new ViewHolder();
            viewHolder.tvplaylistname = convertView.findViewById(R.id.textviewplaylistname);
            viewHolder.imgbackground = convertView.findViewById(R.id.imagebackgroundplaylist);
            viewHolder.imgplaylist = convertView.findViewById(R.id.imageviewplaylist);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Playlist playlist = getItem(position);
        Picasso.get().load(playlist.getPlaylistBackground()).into(viewHolder.imgbackground);
        Picasso.get().load(playlist.getPlaylistImage()).into(viewHolder.imgplaylist);
        viewHolder.tvplaylistname.setText(playlist.getPlaylistName());
        return convertView;


    }
}
