package com.example.dkelinske.gsonplayground.filters;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class FilterGroupParser implements JsonDeserializer<List<FilterGroup>> {

    private static final String REFINEMENTS_KEY = "refinements";

    @Override
    public List<FilterGroup> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Log.e("darran", "in type adapter");
        final JsonObject object = json.getAsJsonObject();
        JsonObject refinementsObject = object.getAsJsonObject(REFINEMENTS_KEY);

        Log.e("darran", "the object is: " + object);
        Log.e("darran", "the refinementsObject is: " + refinementsObject);

        FilterGroupInfo filterGroupInfo = new AutoValue_FilterGroupInfo("7","7");

        Filter filter = Filter.create("7","7","7","7");

        List<Filter> filters = Arrays.asList(filter);

        List<FilterGroup> filterGroups = Arrays.asList(FilterGroup.create(filterGroupInfo, filters));
        return filterGroups;
    }
}
