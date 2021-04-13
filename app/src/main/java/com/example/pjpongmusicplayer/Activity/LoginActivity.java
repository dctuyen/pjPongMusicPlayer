package com.example.pjpongmusicplayer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pjpongmusicplayer.Models.CommonMethod;
import com.example.pjpongmusicplayer.Models.User;
import com.example.pjpongmusicplayer.R;
import com.example.pjpongmusicplayer.Services.APISerivce;
import com.example.pjpongmusicplayer.Services.DataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText edAccount, edPassword;
    Button btRegistration,btLogin;
    String username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edAccount = (EditText) findViewById(R.id.edAccountLogin);
        edPassword = (EditText)findViewById(R.id.edPasswordLogin);
        username = edAccount.getText().toString();
        password = edPassword.getText().toString();
        btLogin = (Button)findViewById(R.id.btnLogin);
        btRegistration = (Button)findViewById(R.id.btnRegistration);
        btRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent layoutRegistration = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(layoutRegistration);
            }
        });
        edAccount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    if(edAccount.getText().toString().equals(""))
                        Toast.makeText(getApplicationContext(),"Bạn không thể bỏ trống tài khoản",Toast.LENGTH_SHORT).show();
            }
        });

        edPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                    if(edPassword.getText().toString().equals(""))
                        Toast.makeText(getApplicationContext(),"Bạn không thể bỏ trống mật khẩu",Toast.LENGTH_SHORT).show();
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkValidation()) {
                    if(CommonMethod.isNetworkAvailable(LoginActivity.this))
                        LoginRetrofit(username,password);
                    else
                        CommonMethod.showAlert("Không có kết nối internet!",LoginActivity.this);
                }
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    private void LoginRetrofit(String account,String password) {
        final User login = new User(account,password);
        DataService dataService = APISerivce.getService();
        Call<User> call1 = dataService.createUser(login);
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response <User> response) {
                User user = response.body();
                Log.e("keshav", "user 1 --> "+ user);
                if(user != null) {
                    Log.e("keshav", "getUserId         --> "+ user.getUserId());
                    Log.e("keshav", "getName           --> "+ user.getName());
                    Log.e("keshav", "getPhoneNumber    --> "+ user.getPhoneNumber());
                    String responseCode = user.getResponseMessage();
                    Log.e("keshav", "getResponseMessage --> "+ user.getResponseMessage());
                    if (responseCode != null && responseCode.equals("404")) {
                        Toast.makeText(LoginActivity.this, "Invalid Login Details \n Please try again", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Welcome " + user.getName(), Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "onFailure called ", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });

    }

    public boolean checkValidation() {
        username = edAccount.getText().toString();
        password = edPassword.getText().toString();

        Log.e("Keshav", "account -> " + username);
        Log.e("Keshav", "password -> " + password);

        if (edAccount.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("UserId Cannot be left blank", LoginActivity.this);
            return false;
        } else if (edPassword.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("password Cannot be left blank", LoginActivity.this);
            return false;
        }
        return true;
    }
}