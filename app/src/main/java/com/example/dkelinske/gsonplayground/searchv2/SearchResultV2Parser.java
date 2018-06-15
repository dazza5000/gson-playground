package com.example.dkelinske.gsonplayground.searchv2;

import com.example.dkelinske.gsonplayground.filters.FilterGroup;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SearchResultV2Parser implements JsonDeserializer<SearchResultV2> {

    @Override
    public SearchResultV2 deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        SearchResultV2 searchResultV2 = gson.fromJson(json, SearchResultV2.class);

        List<FilterGroup> filterGroups = context.deserialize(json, new TypeToken<List<FilterGroup>>(){}.getType());
        searchResultV2.setFilterGroups(filterGroups);
        return searchResultV2;
    }
}
