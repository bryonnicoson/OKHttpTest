package com.bryonnicoson.okhttptest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bryon on 7/24/16.
 */
public class Span {
    @SerializedName("latitude_delta")
    public Double latitudeDelta;
    @SerializedName("longitude_delta")
    public Double longitudeDelta;

    public Span() {
        // empty constructor
    }

    public Double getLatitudeDelta() {
        return latitudeDelta;
    }

    public Double getLongitudeDelta() {
        return longitudeDelta;
    }
}
