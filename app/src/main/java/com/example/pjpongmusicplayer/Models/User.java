package com.example.pjpongmusicplayer.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    @SerializedName("UserId")
    @Expose
    private String UserId;

    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("PhoneNumber")
    @Expose
    private String PhoneNumber;

    @SerializedName("Birthday")
    @Expose
    private String Birthday;
    @SerializedName("Account")
    @Expose
    private String Account;

    @SerializedName("Password")
    @Expose
    private String Password;

    @SerializedName("Favorite")
    @Expose
    private String Favorite;
    @SerializedName("ResponseMessage")
    private String ResponseMessage;
    public User(){}
//set data
    public void setPhoneNumber(String phone) {
         this.PhoneNumber = phone;
    }

    public void setName(String name) {
        this.Name =name;
    }

    public void setBirthday(String btd) {
        this.Birthday =btd;
    }
    public void setAccount(String acc) {
        this.Account = acc;
    }

    public void setPassword(String pw) {
        this.Password =pw;
    }

    public void setResponseMessage(String rpmess) {
        this.ResponseMessage= rpmess;
    }


    //get data
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getBirthday(){
        return Birthday;
    }

    public String getUserId() {
        return UserId;
    }

    public String getName() {
        return Name;
    }

    public String getAccount(){
        return Account;
    }

    public String getPassword(){
        return Password;
    }
    public String getResponseMessage() { return ResponseMessage;}
 }
