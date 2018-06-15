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

public class FilterGroupParser implements JsonDeserializer<List<FilterGroup>> {

    private static final String FIELD_NAME_KEY = "fieldName";
    private static final String REFINEMENTS_KEY = "refinements";
    private static final String REFINEMENT_VALUES_KEY = "refinementValues";
    private static final String LINK_KEY = "link";
    private static final String FILTER_DELIMITER = ":";
    private static final String TEXT_KEY = "text";

    @Override
    public List<FilterGroup> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Log.e("darran", "in type adapter");
//        final JsonObject object = json.getAsJsonObject();
//        JsonObject refinementsObject = object.getAsJsonObject(REFINEMENTS_KEY);
//
//        Log.e("darran", "the object is: " + object);
//        Log.e("darran", "the refinementsObject is: " + refinementsObject);
//
//        FilterGroupInfo filterGroupInfo = new AutoValue_FilterGroupInfo("7","7");
//
//        Filter filter = Filter.create("7","7","7","7");
//
//        List<Filter> filters = Arrays.asList(filter);
//
//        List<FilterGroup> filterGroups = Arrays.asList(FilterGroup.create(filterGroupInfo, filters));

        JsonObject jsonObject =  json.getAsJsonObject();
                JsonObject refinementObject = jsonObject.get(REFINEMENTS_KEY).getAsJsonObject();
        Log.e("darran", "the refinement object member count is: "+refinementObject.keySet().size());
        List<FilterGroup> filterGroups = new ArrayList<>();
        for (String key : refinementObject.keySet()) {
            Log.e("darran", "This key is: "+key);

            List<Filter> filters = new ArrayList<>();

            JsonObject filterGroupJsobObject = refinementObject.get(key).getAsJsonObject();
            JsonObject refinementValues = filterGroupJsobObject.getAsJsonObject(REFINEMENT_VALUES_KEY);
            for (String refinementValueKey : refinementValues.keySet()) {
                JsonObject refinement = refinementValues.getAsJsonObject(refinementValueKey);

                String linkText = refinement.get(LINK_KEY).getAsString() ;
                String id = linkText.substring(linkText.lastIndexOf(FILTER_DELIMITER) + 1);

                filters.add(Filter.create(
                        id,
                        key,
                        refinement.get(TEXT_KEY).getAsString(),
                        linkText));
            }


            String filterGroupInfoName = refinementObject.get(key).getAsJsonObject().get(FIELD_NAME_KEY).getAsString();

            Log.e("darran", "The field name is: " + filterGroupInfoName);

            FilterGroupInfo filterGroupInfo = FilterGroupInfo.create(filterGroupInfoName, key);
            FilterGroup filterGroup =
                    FilterGroup.create(filterGroupInfo, filters);
            filterGroups.add(filterGroup);
        }
        return filterGroups;
    }
}
