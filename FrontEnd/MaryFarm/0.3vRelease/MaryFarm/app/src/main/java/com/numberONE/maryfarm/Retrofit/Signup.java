package com.numberONE.maryfarm.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Signup {
    @SerializedName("kakaoId")
    @Expose
    private String kakaoId;

    @SerializedName("nickname")
    @Expose
    private String nickname;

    public Signup(String kakaoId, String nickname) {
        this.kakaoId = kakaoId;
        this.nickname = nickname;
    }

    public String getKakaoId() {
        return kakaoId;
    }

    public String getNickname() {
        return nickname;
    }
}
