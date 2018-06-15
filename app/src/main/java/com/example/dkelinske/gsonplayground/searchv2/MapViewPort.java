package com.example.dkelinske.gsonplayground.searchv2;


import java.io.Serializable;

public class MapViewPort implements Serializable {

    private GeoCode southwest;
    private GeoCode northeast;

    public GeoCode getNortheast() {
        return northeast;
    }

    public GeoCode getSouthwest() {
        return southwest;
    }

}
