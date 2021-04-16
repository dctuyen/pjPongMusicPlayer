package com.example.pjpongmusicplayer.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pjpongmusicplayer.R;

public class Fragment_Change_Password extends Fragment {
    View view;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_change_pw,container,false);
        TextView tvNameR = (TextView) view.findViewById(R.id.tvNamePw);
        TextView tvAccountR = (TextView) view.findViewById(R.id.tvAccountPw);
        assert getArguments() != null;
        String name = getArguments().getString("user_name");
        String account = getArguments().getString("account");

        tvNameR.setText      ("Họ và tên      :  "+ name);
        tvAccountR.setText   ("Tài khoản      :  "+account);


        return view;
    }
}
