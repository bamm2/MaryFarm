package com.example.kakao;

import android.app.Application;
import com.kakao.sdk.common.KakaoSdk;

public class KakaoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this, "1fc6b60080fc2f00d7f43085d079e13e");
    }
}
