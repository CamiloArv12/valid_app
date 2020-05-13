package com.carevalo.valid_app.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.StringDef;

public class AnnotationNetwork {
    public static final String BASE = "http://ws.audioscrobbler.com";
    public static final String ARTIST_METHOD = "geo.gettopartists";

    @StringDef({BASE, ARTIST_METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Network {}

}


