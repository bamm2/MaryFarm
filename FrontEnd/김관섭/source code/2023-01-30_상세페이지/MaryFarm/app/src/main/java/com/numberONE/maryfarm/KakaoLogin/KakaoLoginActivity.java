package com.numberONE.maryfarm.KakaoLogin;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.kakao.sdk.user.UserApiClient;
import com.numberONE.maryfarm.ui.home.HomeFragment;
import com.numberONE.maryfarm.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KakaoLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao_login);

        Log.d("KeyHash", getKeyHash());
        ImageButton kakao_login_button = (ImageButton)findViewById(R.id.kakao_login_btn);
        kakao_login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(KakaoLoginActivity.this)){
                    login();
                }
                else{
                    accountLogin();
                }
            }
        });
    }

    // 회원인 경우
    public void login(){
        String TAG = "login()";
        UserApiClient.getInstance().loginWithKakaoTalk(KakaoLoginActivity.this,(oAuthToken, error) -> {
            if (error != null) {
                Log.e(TAG, "로그인 실패", error);
            } else if (oAuthToken != null) {
                Log.i(TAG, "로그인 성공(토큰) (회원) : " + oAuthToken.getAccessToken());
                getUserInfo();
            }
            return null;
        });
    }

    // 회원이 아닌 경우
    public void accountLogin(){
        String TAG = "accountLogin()";
        UserApiClient.getInstance().loginWithKakaoAccount(KakaoLoginActivity.this,(oAuthToken, error) -> {
            if (error != null) {
                Log.e(TAG, "로그인 실패", error);
            } else if (oAuthToken != null) {
                Log.i(TAG, "로그인 성공(토큰) (비회원, 회원가입 성공 )  : " + oAuthToken.getAccessToken());
                getUserInfo();
            }
            return null;
        });
    }

    public void getUserInfo(){
        String TAG = "getUserInfo()";
        UserApiClient.getInstance().me((user, meError) -> {
            if (meError != null) {
                Log.e(TAG, "사용자 정보 요청 실패", meError);
            } else {
                System.out.println("로그인 완료");
                Log.i(TAG, user.getId()+"");
                String user_id=user.getId()+" "; // 문자열로 변환

                // user의 id(key값) 넘겨주기
                Intent intent = new Intent(KakaoLoginActivity.this,
                        HomeFragment.class);
                intent.putExtra("user_id",user_id);
                startActivity(intent);

//                {,
//                    Log.i(TAG, "사용자 정보 요청 성공" +
//                            "\n회원번호: "+user.getId() +
//                            "\n이메일: "+user.getKakaoAccount().getEmail());
//                }

//                Account user1 = user.getKakaoAccount();
//                System.out.println("사용자 계정" + user1);
            }
            return null;
        });
    }

    // 키해시 얻기
    public String getKeyHash(){
        try{
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            if(packageInfo == null) return null;
            for(Signature signature: packageInfo.signatures){
                try{
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
                    return android.util.Base64.encodeToString(md.digest(), Base64.NO_WRAP);
                }catch (NoSuchAlgorithmException e){
                    Log.w("getKeyHash", "Unable to get MessageDigest. signature="+signature, e);
                }
            }
        }catch(PackageManager.NameNotFoundException e){
            Log.w("getPackageInfo", "Unable to getPackageInfo");
        }
        return null;
    }
}