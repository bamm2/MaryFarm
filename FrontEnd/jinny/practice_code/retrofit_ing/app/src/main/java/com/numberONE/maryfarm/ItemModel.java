package com.numberONE.maryfarm;

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
}
