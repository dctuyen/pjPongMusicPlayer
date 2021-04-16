package com.example.pjpongmusicplayer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pjpongmusicplayer.Model.CommonMethod;
import com.example.pjpongmusicplayer.R;
import com.example.pjpongmusicplayer.Service.APIService;
import com.example.pjpongmusicplayer.Service.Dataservice;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    EditText edAccountR,edPasswordR,edNameR, edPhoneR, edBirthdayR, edConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
         edAccountR = findViewById(R.id.edAccountRegist);
         edPasswordR = findViewById(R.id.edPasswordRegist);
         edNameR = findViewById(R.id.edNameRegist);
         edConfirmPassword = findViewById(R.id.edConfirmPassword);
         edBirthdayR = findViewById(R.id.edBirthday);
         edPhoneR = findViewById(R.id.edPhoneRegist);
         Button btRegistration = findViewById(R.id.btnRegister);

         btRegistration.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(checkValidation()) {
                     if(CommonMethod.isNetworkAvailable(RegistrationActivity.this))
                         CreateRetrofit(edNameR.getText().toString(),edBirthdayR.getText().toString(),edPhoneR.getText().toString(),edAccountR.getText().toString(),edPasswordR.getText().toString());
                     else
                         CommonMethod.showAlert("Không có kết nối internet!",RegistrationActivity.this);
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
    public boolean checkValidation() {
        String username = edAccountR.getText().toString();
        String password = edBirthdayR.getText().toString();

        Log.e("Keshav", "account -> " + username);
        Log.e("Keshav", "password -> " + edBirthdayR.getText().toString());

        if (edAccountR.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("Không thể bỏ trống tài khoản", RegistrationActivity.this);
            return false;
        } else if (edPasswordR.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("Không thể bỏ trống mật khẩu", RegistrationActivity.this);
            return false;
        } else if (edConfirmPassword.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("Không thể bỏ trống mật khẩu xác nhận", RegistrationActivity.this);
            return false;
        } else if (edPhoneR.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("Không thể bỏ trống số điện thoại", RegistrationActivity.this);
            return false;
        } else if (edBirthdayR.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("Không thể bỏ trống ngày sinh", RegistrationActivity.this);
            return false;
        } else if (edNameR.getText().toString().trim().equals("")) {
            CommonMethod.showAlert("Không thể bỏ trống họ tên", RegistrationActivity.this);
            return false;
        }else if (!edPasswordR.getText().toString().trim().equals(edConfirmPassword.getText().toString())) {
            CommonMethod.showAlert("Mật khẩu xác nhận không trùng khớp!", RegistrationActivity.this);
            edConfirmPassword.setText("");
            return false;
        }
        return true;
    }

    private void CreateRetrofit(String name,  String birthday, String phone, String account,String password) {
        Dataservice dataService = APIService.getService();
        Call<ResponseBody> call1 = dataService.createUser(name,birthday,phone,account,password);
        call1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.isSuccessful()) {
                    try {
                        assert response.body() != null;
                        JSONObject jsonObject= new JSONObject(response.body().string());
                        String msg=jsonObject.getString("message");
                        if(msg.equals("Tên đăng nhập đã có người sử dụng!")){
                            CommonMethod.showAlert(msg, RegistrationActivity.this);
                            edAccountR.setText("");
                        }
                        else {
                            CommonMethod.showAlert(msg, RegistrationActivity.this);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Không thành công \n Vui lòng thử lại sau! ", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });

    }
}