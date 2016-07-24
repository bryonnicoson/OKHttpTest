package com.bryonnicoson.okhttptest;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by bryon on 7/24/16.
 */
public class Region {

    @SerializedName("span")
    public Span span;
    @SerializedName("center")
    public Center center;

    public Region() {
        // empty constructor
    }
}
