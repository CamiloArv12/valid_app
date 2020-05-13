package com.carevalo.valid_app.utils;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;
import androidx.annotation.StringDef;

public class AnnotationPicSize {

    public static final String SMALL = "small";
    public static final String MEDIUM = "medium";
    public static final String LARGE = "large";
    public static final String EXTRALARGE = "extralarge";
    public static final String MEGA = "mega";


    @StringDef({SMALL,MEDIUM, LARGE, EXTRALARGE, MEGA})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PicSize {}

}
