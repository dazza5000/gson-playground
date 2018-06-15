package com.example.dkelinske.gsonplayground.filters;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FilterGroupParser implements JsonDeserializer<List<FilterGroup>> {

    private static final String FIELD_NAME_KEY = "fieldName";
    private static final String REFINEMENTS_KEY = "refinements";
    private static final String REFINEMENT_VALUES_KEY = "refinementValues";
    private static final String LINK_KEY = "link";
    private static final String FILTER_DELIMITER = ":";
    private static final String TEXT_KEY = "text";

    @Override
    public List<FilterGroup> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject =  json.getAsJsonObject();
        JsonObject refinementObject = jsonObject.get(REFINEMENTS_KEY).getAsJsonObject();
        List<FilterGroup> filterGroups = new ArrayList<>();

        for (Map.Entry<String, JsonElement> filterGroupEntry : refinementObject.entrySet()) {
            String filterGroupId = filterGroupEntry.getKey();
            List<Filter> filters = new ArrayList<>();

            JsonObject filterGroupJsonObject = filterGroupEntry.getValue().getAsJsonObject();
            JsonObject refinementValues = filterGroupJsonObject.getAsJsonObject(REFINEMENT_VALUES_KEY);

            for (Map.Entry<String, JsonElement> refinementEntry: refinementValues.entrySet()) {
                JsonObject refinement = refinementEntry.getValue().getAsJsonObject();

                String linkText = refinement.get(LINK_KEY).getAsString() ;
                String id = linkText.substring(linkText.lastIndexOf(FILTER_DELIMITER) + 1);

                filters.add(Filter.create(
                        id,
                        filterGroupId,
                        refinement.get(TEXT_KEY).getAsString(),
                        linkText));
            }

            String filterGroupInfoName = filterGroupJsonObject.get(FIELD_NAME_KEY).getAsString();

            FilterGroupInfo filterGroupInfo = FilterGroupInfo.create(filterGroupInfoName, filterGroupId);
            FilterGroup filterGroup = FilterGroup.create(filterGroupInfo, filters);

            filterGroups.add(filterGroup);
        }

        return filterGroups;
    }
}
