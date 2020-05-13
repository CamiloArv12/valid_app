package com.carevalo.valid_app.ui.artist;


import com.carevalo.valid_app.network.ApiAdapter;
import com.carevalo.valid_app.network.ApiService;
import com.carevalo.valid_app.network.response.ArtistResponse;
import com.carevalo.valid_app.utils.AnnotationNetwork;

import java.lang.reflect.Parameter;
import java.util.Properties;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistUseCase {

    Properties prop = new Properties();
    private static String COUNTRY = "country";
    private static String API_KEY = "api_key";
    private static String API_FORMAT = "api_format";

    private static ArtistUseCase atristsUseCase;

    public static ArtistUseCase getInstance(){
        if (atristsUseCase == null){
            atristsUseCase = new ArtistUseCase();
        }
        return atristsUseCase;
    }

    private ApiService apiService;

    public ArtistUseCase(){
        apiService = ApiAdapter.createService(ApiService.class);
    }

    public MutableLiveData<ArtistResponse> getArtists(){
        final MutableLiveData<ArtistResponse> artistsData = new MutableLiveData<>();
        apiService.getArtists(AnnotationNetwork.ARTIST_METHOD, prop.getProperty(COUNTRY),
                                prop.getProperty(API_KEY), prop.getProperty(API_FORMAT))
                .enqueue(new Callback<ArtistResponse>() {
            @Override
            public void onResponse(Call<ArtistResponse> call, Response<ArtistResponse> response) {
                if (response.isSuccessful()){
                    artistsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArtistResponse> call, Throwable t) {
                artistsData.setValue(null);
            }
        });
        return artistsData;
    }

}
