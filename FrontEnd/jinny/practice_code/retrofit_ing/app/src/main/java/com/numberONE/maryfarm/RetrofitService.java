package com.numberONE.maryfarm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("/api/diary/user/1111")
    Call<List<ItemModel>> getList();
}
