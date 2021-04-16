package com.example.pjpongmusicplayer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import com.example.pjpongmusicplayer.Model.CommonMethod;
import com.example.pjpongmusicplayer.Model.User;
import com.example.pjpongmusicplayer.R;
import com.example.pjpongmusicplayer.Service.APIService;
import com.example.pjpongmusicplayer.Service.Dataservice;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText edAccount, edPassword;
    Button btRegistration,btLogin;
    String username, password;
    @SuppressLint("SimpleDateFormat")
    DateFormat df = new SimpleDateFormat("MM-dd");
    String date = df.format(Calendar.getInstance().getTime());

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
        Dataservice dataService = APIService.getService();
        Call<ResponseBody> call1 = dataService.checkUser(account,password);
        call1.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response <ResponseBody> response) {
                if(response.isSuccessful()) {
                    try {
                        assert response.body() != null;
                        JSONObject jsonObject= new JSONObject(response.body().string());
                        if(jsonObject.getString("result").equals("success")){
                            User user = new User();
                            user.setName(jsonObject.getString("user_name"));
                            user.setPhoneNumber(jsonObject.getString("phone"));
                            user.setBirthday(jsonObject.getString("birthday"));
                            user.setAccount(account);
                            Intent lyMenu = new Intent(LoginActivity.this,MenuActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("user_name",user.getName());
                            bundle.putString("user_phone",user.getPhoneNumber());
                            bundle.putString("birthday",user.getBirthday());
                            bundle.putString("account",user.getAccount());
                            lyMenu.putExtras(bundle);
                            startActivity(lyMenu);
                        }
                        else {
                            CommonMethod.showAlert("Thông tin đăng nhập không đúng!", LoginActivity.this);
                            edAccount.setText("");
                            edPassword.setText("");

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else
                    CommonMethod.showAlert("Đăng nhập không thành công!", LoginActivity.this);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Không thành công \n Vui lòng thử lại sau! ", Toast.LENGTH_SHORT).show();
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
            CommonMethod.showAlert("Không thể bỏ trống tài khoản", LoginActivity.this);
            return false;
        } else if (edPassword.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("Không thể bỏ trống mật khẩu", LoginActivity.this);
            return false;
        }
        return true;
    }
}