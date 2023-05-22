package com.test.app;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class kakaoApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        // Kakao SDK 초기화
        KakaoSdk.init(this,"f059c3fbe021d13fa0a5ffa33e906bf8");
    }
}
