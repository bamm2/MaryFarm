package com.numberONE.maryfarm.Retrofit;

import com.numberONE.maryfarm.Retrofit.Diary.UserApi;
import com.numberONE.maryfarm.Retrofit.Diary.UserItem;
import com.numberONE.maryfarm.Retrofit.practice.UserData;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitApiSerivce {

//     diary api 시작

//    @POST("diary/follower")
//    Call<UserApi> postFollowerFeed(@Body String userid);

    @POST("diary/init")
    Call<UserData> postInitFeed(@Body UserData user);

    @GET("diary/user/{id}")
    Call<article> get(@Path("id") String id);

//    diary api 끝

}
