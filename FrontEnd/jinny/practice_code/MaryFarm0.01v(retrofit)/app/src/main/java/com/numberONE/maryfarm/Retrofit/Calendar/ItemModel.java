package com.numberONE.maryfarm.Retrofit.Calendar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemModel {
    @Expose
    public long id;
    @SerializedName("plantid")
    public String plant;
    @SerializedName("title")
    public String content;
    @SerializedName("imagepath")
    public String imagepath;

    public long getId() {
        return id;
    }

    public String getPlant() {
        return plant;
    }

    public String getContent() {
        return content;
    }

    public String getImagepath() {
        return imagepath;
    }
}
