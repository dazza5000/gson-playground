package com.example.dkelinske.gsonplayground.filters;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Filter implements Parcelable {
    public abstract String id();
    public abstract String groupId();
    public abstract String name();
    public abstract String refineByQueryArgument();

    public static Filter create(String id, String groupId, String name, String refineByQueryArgument) {
        return new AutoValue_Filter(id, groupId, name, refineByQueryArgument);
    }

    public final String toString() {
        return refineByQueryArgument();
    }

    public static TypeAdapter<Filter> typeAdapter(Gson gson) {
        return new AutoValue_Filter.GsonTypeAdapter(gson);
    }
}
