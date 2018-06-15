package com.example.dkelinske.gsonplayground.filters;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

@AutoValue
public abstract class FilterGroup implements Parcelable {

    public abstract FilterGroupInfo groupInfo();
    public abstract List<Filter> filters();

    public static FilterGroup create(FilterGroupInfo filterGroupInfo, List<Filter> filters) {
        return new AutoValue_FilterGroup(filterGroupInfo, filters);
    }

    public static TypeAdapter<FilterGroup> typeAdapter(Gson gson) {
        return new AutoValue_FilterGroup.GsonTypeAdapter(gson);
    }

}
