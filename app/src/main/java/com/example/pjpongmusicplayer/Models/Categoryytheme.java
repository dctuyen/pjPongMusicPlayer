package com.example.pjpongmusicplayer.Models;

import android.content.res.Resources;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Categoryytheme {

@SerializedName("Category")
@Expose
private List<Category> category = null;
@SerializedName("Theme")
@Expose
private List<Resources.Theme> theme = null;

public List<Category> getCategory() {
return category;
}

public void setCategory(List<Category> category) {
this.category = category;
}

public List<Resources.Theme> getTheme() {
return theme;
}

public void setTheme(List<Resources.Theme> theme) {
this.theme = theme;
}

}