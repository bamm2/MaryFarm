package com.numberONE.maryfarm.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL ="http://54.180.86.161:8080/api/";
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
                    retrofit = new Retrofit.Builder() // 객체 생성
                    .baseUrl(BASE_URL) // 서버 url 설정
                    .addConverterFactory(GsonConverterFactory.create()) // 데이터 파싱 설정 (Gson)
                    .build(); // 통신하여 데이터를 파싱한 retrofit 객체 생성 완료
        }
        return retrofit;
    }
}
