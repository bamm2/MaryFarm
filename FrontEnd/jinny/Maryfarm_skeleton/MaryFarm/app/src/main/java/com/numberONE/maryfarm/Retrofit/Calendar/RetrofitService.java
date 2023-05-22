package com.numberONE.maryfarm.Retrofit.Calendar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitService {
//    @GET("diary/user/1111")
    @POST("maryfarm-plant-service/api/plant/month/search")
    Call<List<ItemModel>> getList(@Body CalendarDateModel CalendarDate);
    @POST("maryfarm-calendar-service/api/calendar/search")
    Call<List<MemoModel>> getPlant(@Body CalendarPickModel CalendarPick);
}

