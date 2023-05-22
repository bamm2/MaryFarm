package com.numberONE.maryfarm.KakaoLogin;

import android.app.Application;
import com.kakao.sdk.common.KakaoSdk;

public class KakaoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this, "2d4ab065b4f4050039cdc9af3e888398");
    }
}
