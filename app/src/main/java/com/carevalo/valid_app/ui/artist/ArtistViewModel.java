package com.carevalo.valid_app.ui.artist;

import com.carevalo.valid_app.network.ApiAdapter;
import com.carevalo.valid_app.network.response.Artist;
import com.carevalo.valid_app.network.response.ArtistResponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArtistViewModel extends ViewModel {

    private MutableLiveData<ArtistResponse> mutableLiveData;
    private ArtistUseCase artistUseCase;

    public void init() {
        if (mutableLiveData != null){
            return;
        }
        artistUseCase = ArtistUseCase.getInstance();
        mutableLiveData = artistUseCase.getArtists();
    }

    public ArtistViewModel() { }

    public LiveData<ArtistResponse> getArtistsUseCase() {
        return mutableLiveData;
    }


}