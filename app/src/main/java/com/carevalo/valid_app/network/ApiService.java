package com.carevalo.valid_app.network;

import com.carevalo.valid_app.network.response.ArtistResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/2.0/?method=geo.gettopartists&country=spain&api_key=829751643419a7128b7ada50de590067&format=json")
    Call<ArtistResponse> getArtists(
            @Query("method") String method,
            @Query("country") String country,
            @Query("api_key") String api_key,
            @Query("format") String format );
}
