package com.carevalo.valid_app.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopArtists {

    @SerializedName("artist")
    @Expose
    private List<Artist> artist;
    @SerializedName("@attr")
    @Expose
    private AttrArtist attr;

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public AttrArtist getAttr() {
        return attr;
    }

    public void setAttr(AttrArtist attr) {
        this.attr = attr;
    }
}
