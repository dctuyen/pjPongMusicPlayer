package com.example.pjpongmusicplayer.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pjpongmusicplayer.Adapter.MainViewPagerAdapter;
import com.example.pjpongmusicplayer.Fragment.Fragment_Change_Password;
import com.example.pjpongmusicplayer.Fragment.Fragment_Home;
import com.example.pjpongmusicplayer.Fragment.Fragment_Info;
import com.example.pjpongmusicplayer.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MenuActivity extends AppCompatActivity {
    String account,name,phone,birthday;
    TabLayout tabLayout;
    ViewPager viewPager;
    Bundle bundles = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();

        account = intent.getStringExtra("account");
        name = intent.getStringExtra("user_name");
        phone = intent.getStringExtra("user_phone");
        birthday = intent.getStringExtra("birthday");
        bundles.putString("user_name",name);
        bundles.putString("user_phone",phone);
        bundles.putString("birthday",birthday);
        bundles.putString("account",account);
        Toast.makeText(this, "Xin chào "+ name, Toast.LENGTH_SHORT).show();

        anhxa();
        init();
    }

    private void init() {
        Fragment_Change_Password fragment_change_password = new Fragment_Change_Password();
        Fragment_Info fragment_info = new Fragment_Info();
        fragment_info.setArguments(bundles);
        fragment_change_password.setArguments(bundles);

        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Home(),"Trang chủ");
        mainViewPagerAdapter.addFragment(fragment_info,"Thông tin");
        mainViewPagerAdapter.addFragment(fragment_change_password,"Đổi mật khẩu");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_baseline_home_24);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.ic_baseline_person_pin_24);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.ic_baseline_lock_open_24);
    }
    private void anhxa() {

        tabLayout=findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }
}