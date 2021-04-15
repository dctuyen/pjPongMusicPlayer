package com.example.pjpongmusicplayer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.pjpongmusicplayer.Model.Banner;
import com.example.pjpongmusicplayer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Banner> arrayListbanner;

    public BannerAdapter(Context context, ArrayList<Banner> arrayListbanner) {
        this.context = context;
        this.arrayListbanner = arrayListbanner;
    }

    @Override
    public int getCount() {
        return arrayListbanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.banner_row,null);

        ImageView imgbackgroundbanner = view.findViewById(R.id.imageviewbackgroundbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imageviewbanner);
        TextView tvtitlesongbanner = view.findViewById(R.id.textviewtitlebannersong);
        TextView tvcontentbanner = view.findViewById(R.id.textviewcontentbanner);

        Picasso.get().load(arrayListbanner.get(position).getBannerImage()).into(imgbackgroundbanner);
        Picasso.get().load(arrayListbanner.get(position).getSongImage()).into(imgsongbanner);
        tvtitlesongbanner.setText(arrayListbanner.get(position).getSongName());
        tvcontentbanner.setText(arrayListbanner.get(position).getBannerContent());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);

    }
}
