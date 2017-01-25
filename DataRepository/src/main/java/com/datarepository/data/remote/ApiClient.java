package com.datarepository.data.remote;

import com.datarepository.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by ThangNTX on 12/1/2016.
 */

public class ApiClient {

    private static Retrofit INSTANCE;

    public synchronized static Retrofit getClient() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return INSTANCE;
    }
}