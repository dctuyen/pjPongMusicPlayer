package com.example.pjpongmusicplayer.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pjpongmusicplayer.R;

public class Fragment_Info extends Fragment {
    View view;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info,container,false);
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvAccount = (TextView) view.findViewById(R.id.tvAccount);
        TextView tvBirthday = (TextView) view.findViewById(R.id.tvBirthday);
        TextView tvPhone = (TextView)view.findViewById(R.id.tvPhone);
        assert getArguments() != null;
        String name = getArguments().getString("user_name");
        String account = getArguments().getString("account");
        String phone = getArguments().getString("user_phone");
        String brd = getArguments().getString("birthday");

        tvName.setText      ("Họ và tên      :  "+ name);
        tvAccount.setText   ("Tài khoản      :  "+account);
        tvBirthday.setText  ("Ngày sinh      :  "+brd);
        tvPhone.setText     ("Số điện thoại  :  "+phone);

        return view;
    }
}
