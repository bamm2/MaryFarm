package com.numberONE.maryfarm.Retrofit.practice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("dto")
    @Expose
    private UserData dto;

    @SerializedName("image")
    @Expose
    private String image;

    public UserData getDto() {
        return dto;
    }

    public void setDto(UserData dto) {
        this.dto = dto;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "dto=" + dto +
                ", image='" + image + '\'' +
                '}';
    }
}
