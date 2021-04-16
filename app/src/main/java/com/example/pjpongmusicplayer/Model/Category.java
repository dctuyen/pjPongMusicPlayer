package com.example.pjpongmusicplayer.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category {

@SerializedName("category_id")
@Expose
private String categoryId;
@SerializedName("category_name")
@Expose
private String categoryName;
@SerializedName("category_image")
@Expose
private String categoryImage;
@SerializedName("chude_id")
@Expose
private String chudeId;

public String getCategoryId() {
return categoryId;
}

public void setCategoryId(String categoryId) {
this.categoryId = categoryId;
}

public String getCategoryName() {
return categoryName;
}

public void setCategoryName(String categoryName) {
this.categoryName = categoryName;
}

public String getCategoryImage() {
return categoryImage;
}

public void setCategoryImage(String categoryImage) {
this.categoryImage = categoryImage;
}

public String getChudeId() {
return chudeId;
}

public void setChudeId(String chudeId) {
this.chudeId = chudeId;
}

}