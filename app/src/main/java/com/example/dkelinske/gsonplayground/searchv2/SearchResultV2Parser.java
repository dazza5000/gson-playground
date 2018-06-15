package com.example.dkelinske.gsonplayground.searchv2;

import com.example.dkelinske.gsonplayground.filters.FilterGroup;
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
        SearchResultV2 searchResultV2 = new SearchResultV2();

        JsonObject refinementsObject = json.getAsJsonObject().get("refinements").getAsJsonObject();
        List<FilterGroup> filterGroups = context.deserialize(json, new TypeToken<List<FilterGroup>>(){}.getType());
        searchResultV2.setFilterGroups(filterGroups);
        return searchResultV2;
    }
}
