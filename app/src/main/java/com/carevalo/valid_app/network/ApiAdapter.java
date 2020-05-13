package com.carevalo.valid_app.network;

import com.carevalo.valid_app.utils.AnnotationNetwork;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AnnotationNetwork.BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
