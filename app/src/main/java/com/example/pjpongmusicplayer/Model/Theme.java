package com.example.pjpongmusicplayer.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Theme {

@SerializedName("theme_id")
@Expose
private String themeId;
@SerializedName("theme_name")
@Expose
private String themeName;
@SerializedName("theme_image")
@Expose
private String themeImage;

public String getThemeId() {
return themeId;
}

public void setThemeId(String themeId) {
this.themeId = themeId;
}

public String getThemeName() {
return themeName;
}

public void setThemeName(String themeName) {
this.themeName = themeName;
}

public String getThemeImage() {
return themeImage;
}

public void setThemeImage(String themeImage) {
this.themeImage = themeImage;
}

}