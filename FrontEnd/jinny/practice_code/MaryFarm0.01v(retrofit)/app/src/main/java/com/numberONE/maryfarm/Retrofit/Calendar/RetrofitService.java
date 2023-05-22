package com.numberONE.maryfarm.Retrofit.Calendar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("diary/user/1111")
    Call<List<ItemModel>> getList();
}
