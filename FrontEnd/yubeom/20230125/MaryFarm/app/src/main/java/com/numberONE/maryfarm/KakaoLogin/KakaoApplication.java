package com.numberONE.maryfarm.KakaoLogin;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class KakaoApplication extends Application {
    private static KakaoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //네이티브 앱 키로 초기화
        KakaoSdk.init(this, "f059c3fbe021d13fa0a5ffa33e906bf8");
    }
}
