package com.example.dkelinske.gsonplayground.searchv2;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.Serializable;

/**
 * Returned from search to show the filters used in the search url. These will only be non null
 * depending on what is inside the search url used in the request.
 */
@AutoValue
public abstract class WebLinkSearchRequest implements Serializable {

    @Nullable
    public abstract String q();

    @Nullable
    public abstract String lbsUuid();

    @Nullable
    public abstract Boolean petsIncluded();

    @Nullable
    public abstract Integer regionId();

    @Nullable
    public abstract Integer minBedrooms();

    @Nullable
    public abstract Integer maxBedrooms();

    @Nullable
    public abstract Integer minBathrooms();

    @Nullable
    public abstract Integer maxBathrooms();

    @Nullable
    public abstract Integer minSleeps();

    @Nullable
    public abstract Integer minPrice();

    @Nullable
    public abstract Integer maxPrice();

    @Nullable
    public abstract Integer page();


    public static TypeAdapter<WebLinkSearchRequest> typeAdapter(Gson gson) {
        return new AutoValue_WebLinkSearchRequest.GsonTypeAdapter(gson);
    }
}
