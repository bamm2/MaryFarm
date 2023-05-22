package com.numberONE.maryfarm.KakaoLogin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.numberONE.maryfarm.Retrofit.ServerAPI;
import com.numberONE.maryfarm.Retrofit.Signup;
import com.numberONE.maryfarm.Retrofit.UserInfo;
import com.numberONE.maryfarm.MainActivity;
import com.numberONE.maryfarm.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                String user_id=user.getId()+" "; // 문자열로 변환
                String user_nickname =  user.getKakaoAccount().getProfile().getNickname();

                // # 1-1. 기회원인지 확인
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://i8b308.p.ssafy.io:8000/maryfarm-user-service/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ServerAPI serverAPI = retrofit.create(ServerAPI.class);
                Call<UserInfo> call = serverAPI.getUserInfo(user_id);
                Log.d(TAG, "!!!!"+call);
                Log.d(TAG, "!!!!"+user_id);
                call.enqueue(new Callback<UserInfo>() {
                    int a = 777;

                    @Override
                    public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                        UserInfo userInfo = response.body();
                        Log.d(TAG, "회원가입 여부 확인 "+userInfo);
                        Log.d(TAG, "onResponse: "+response.code());
                        // # 1-2. 기회원이 아닌 경우, Sign up 진행
                        if (userInfo==null){
                            Retrofit retrofit1 = new Retrofit.Builder()
                                    .baseUrl("http://i8b308.p.ssafy.io:8000/maryfarm-user-service/api/")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();

                            ServerAPI serverAPI1 = retrofit1.create(ServerAPI.class);

                            Signup signup = new Signup(user_id, user_nickname);

                            Call<Signup> call1 = serverAPI1.postUserInfo(signup);
                            call1.enqueue(new Callback<Signup>() {
                                @Override
                                public void onResponse(Call<Signup> call1, Response<Signup> response) {
                                    List<Signup> signupList = new ArrayList<>();
                                    signupList.add(response.body());
                                }

                                @Override
                                public void onFailure(Call<Signup> call1, Throwable t) {
                                    Log.d("Signup", t.toString());
                                }
                            });
                        } else {
                            Log.d(TAG, "Already Signup!!!!!");
                        }
                    }

                    @Override
                    public void onFailure(Call<UserInfo> call, Throwable t) {
                        t.printStackTrace();
                        Log.d(TAG, "onFailure: "+a);
                        Log.d("kakaoLogin", t.toString());
                    }
                });

                // 카카오 기본 닉네임 가져오기
                Log.d(TAG, "invoke: nickname=" + user.getKakaoAccount().getProfile().getNickname());

                // 카카오 유저 아이디  sharedpreference에 저장!
                Log.d(TAG, "getUserInfo: "+user_id);
                SharedPreferences pref;
                SharedPreferences.Editor editor;

                String userId;

                // 1. Shared Preference 초기화
                pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
                editor = pref.edit();

                // 2. 저장해둔 값 불러오기 ("식별값", 초기값) -> 식별값과 초기값은 직접 원하는 이름과 값으로 작성.
                userId = pref.getString("userId", user_id);   // String 불러오기 (저장해둔 값 없으면 초기값인 _으로 불러옴)
                // 3. 새로운 값(카카오 유저 아이디) 저장
                editor.putString("userId", user_id.toString());
                editor.commit(); // 저장

                // user의 id(key값) 넘겨주기
                Intent intent = new Intent(KakaoLoginActivity.this,
                        MainActivity.class);
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