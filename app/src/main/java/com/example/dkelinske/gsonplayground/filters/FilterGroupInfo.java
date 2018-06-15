package com.example.dkelinske.gsonplayground.filters;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class FilterGroupInfo implements Parcelable {
    public abstract String name();
    public abstract String id();

    public static FilterGroupInfo create(String name, String id) {
        return new AutoValue_FilterGroupInfo(name, id);
    }

    public static TypeAdapter<FilterGroupInfo> typeAdapter(Gson gson) {
        return new AutoValue_FilterGroupInfo.GsonTypeAdapter(gson);
    }
}
