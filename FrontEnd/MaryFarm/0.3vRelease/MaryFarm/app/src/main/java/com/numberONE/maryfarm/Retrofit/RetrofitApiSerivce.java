package com.numberONE.maryfarm.Retrofit;

import com.numberONE.maryfarm.Retrofit.Diary.DiaryInit;
import com.numberONE.maryfarm.Retrofit.Diary.UserApi;
import com.numberONE.maryfarm.Retrofit.Diary.UserItem;
import com.numberONE.maryfarm.Retrofit.practice.UserData;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;

public interface RetrofitApiSerivce {

//     diary api 시작

//    @POST("diary/follower")
//    Call<UserApi> postFollowerFeed(@Body String userid);

    @POST("diary/init")
    Call<UserData> postInitFeed(@Body UserData user);

    @Multipart
    @POST("maryfarm-plant-service/api/diary/init")
    Call<DiaryInit> postInitFeed(@Part MultipartBody.Part file
            , @PartMap Map<String, RequestBody> params);

//    diary api 끝

}
