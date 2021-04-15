package com.example.pjpongmusicplayer.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.pjpongmusicplayer.Adapter.MainViewPagerAdapter;
import com.example.pjpongmusicplayer.Fragment.Fragment_Home;
import com.example.pjpongmusicplayer.Fragment.Fragment_Search;
import com.example.pjpongmusicplayer.R;
import com.google.android.material.tabs.TabLayout;

public class MenuActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }

    private void init() {

        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Home(),"Trang chu");
        mainViewPagerAdapter.addFragment(new Fragment_Search(),"Tim kiem");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconsearch);
    }

    private void anhxa() {

        tabLayout=findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }
}