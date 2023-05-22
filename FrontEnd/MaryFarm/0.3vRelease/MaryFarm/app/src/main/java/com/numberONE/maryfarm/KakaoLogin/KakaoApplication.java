package com.numberONE.maryfarm.KakaoLogin;

import android.app.Application;
import com.kakao.sdk.common.KakaoSdk;

public class KakaoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this, "ca5f329ea3d04e9a001843861e32e8b2");
    }
}

//관섭 key : 1fc6b60080fc2f00d7f43085d079e13e
//유범 key : f059c3fbe021d13fa0a5ffa33e906bf8
//환석 key : ca5f329ea3d04e9a001843861e32e8b2