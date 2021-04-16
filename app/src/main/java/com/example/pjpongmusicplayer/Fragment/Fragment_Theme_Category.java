package com.example.pjpongmusicplayer.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.pjpongmusicplayer.Model.CateagoryTheme;
import com.example.pjpongmusicplayer.Model.Category;
import com.example.pjpongmusicplayer.Model.Theme;
import com.example.pjpongmusicplayer.R;
import com.example.pjpongmusicplayer.Service.APIService;
import com.example.pjpongmusicplayer.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Theme_Category extends Fragment {
    View view;

    HorizontalScrollView horizontalScrollView;
    TextView tvxemthem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_theme_category_today,container,false);
        GetData();

        horizontalScrollView = view.findViewById(R.id.horizontalScrollview);
        tvxemthem = view.findViewById(R.id.textviewxemthem);
        return view;

    }

//    Log.d("chudevatl",t.getMessage());
    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<CateagoryTheme> callback = dataservice.GetCategoryTheme();
        callback.enqueue(new Callback<CateagoryTheme>() {
            @Override
            public void onResponse(Call<CateagoryTheme> call, Response<CateagoryTheme> response) {
                CateagoryTheme categoryytheme = response.body();

                final ArrayList<Theme> themeArrayList = new ArrayList<>();
                themeArrayList.addAll(categoryytheme.getTheme());

                final ArrayList<Category> categoryArrayList = new ArrayList<>();
                categoryArrayList.addAll(categoryytheme.getCategory());

                LinearLayout linearLayout =new LinearLayout(getActivity());
                linearLayout.setOrientation(linearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580,250);
                layout.setMargins(10,20,10,30);
                for (int i =0;i<(themeArrayList.size());i++)
                {
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (themeArrayList.get(i).getThemeImage()!=null)
                    {
                        Picasso.get().load(themeArrayList.get(i).getThemeImage()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                for (int j =0;j<(themeArrayList.size());j++)
                {
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (categoryArrayList.get(j).getCategoryImage()!=null)
                    {
                        Picasso.get().load(categoryArrayList.get(j).getCategoryImage()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }

                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<CateagoryTheme> call, Throwable t) {

            }
        });

    }
}
