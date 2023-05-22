package com.numberONE.maryfarm.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServerAPI {

    @GET("user/{userId}")
    Call<UserInfo> getUserInfo(@Path("userId") String userId);

    @POST("auth/user/signup")
    Call<Signup> postUserInfo(@Body Signup signup);

    @GET("detail")
    Call<DetailsAPI> getDetails();

    @GET("comments")
    Call<List<Comments>> getComments();
}

