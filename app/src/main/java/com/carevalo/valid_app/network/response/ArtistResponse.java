package com.carevalo.valid_app.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtistResponse {
    @SerializedName("topartists")
    @Expose
    private TopArtists topArtists;

    public TopArtists getTopArtists() {
        return topArtists;
    }

    public void setTopArtists(TopArtists topArtists) {
        this.topArtists = topArtists;
    }
}
