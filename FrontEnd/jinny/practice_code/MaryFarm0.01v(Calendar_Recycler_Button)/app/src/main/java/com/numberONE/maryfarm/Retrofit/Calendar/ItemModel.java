package com.numberONE.maryfarm.Retrofit.Calendar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemModel {
    @Expose
    public long id;
    @SerializedName("plantid")
    public String plantid;
    @SerializedName("title")
    public String planttitle;
// 아직 서버에 날짜 데이터 없음
//    @SerializedName("created_at")
//    public String created_at;

    public long getId() { return id; }

    public String getPlantid() {
        return plantid;
    }

    public String getPlanttitle() {
        return planttitle;
    }

//    public String getCreated_at() { return created_at; }
}
