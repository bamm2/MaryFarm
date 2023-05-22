package com.numberONE.maryfarm.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance=null;
    private static RetrofitApiSerivce retrofitApiSerivce;
    private static  final String BASE_URL =" 서버주소 ";

    private RetrofitClient(){
        Retrofit retrofit=new Retrofit.Builder() // 객체 생성
                .baseUrl(BASE_URL) // 서버 url 설정
                .addConverterFactory(GsonConverterFactory.create()) // 데이터 파싱 설정
                .build(); //객체정보 반환
        retrofitApiSerivce=retrofit.create(RetrofitApiSerivce.class);
    }
    private static RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient(); // 시작 시 생성자 호출
        }
        return instance;
    }

    public static RetrofitApiSerivce getRetrofitApiSerivce(){
        return retrofitApiSerivce;
    }

}
