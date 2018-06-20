package com.example.dkelinske.gsonplayground.filters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterGroupListTypeAdapter extends TypeAdapter<List<FilterGroup>> {

    private static final String FIELD_NAME_KEY = "fieldName";
    private static final String REFINEMENT_VALUES_KEY = "refinementValues";
    private static final String LINK_KEY = "link";
    private static final String FILTER_DELIMITER = ":";
    private static final String TEXT_KEY = "text";

    @Override
    public void write(JsonWriter out, List<FilterGroup> value) throws IOException {
        throw new IOException("This adapter is only intended for reading.");
    }

    @Override
    public List<FilterGroup> read(JsonReader in) throws IOException {
        List<FilterGroup> filterGroups = new ArrayList<>();

        in.beginObject();

        while (in.hasNext()) {
            String filterGroupId = in.nextName();
            List<Filter> filters = new ArrayList<>();

            in.beginObject();
            while (in.hasNext()) {
                if (in.nextName().equals(FIELD_NAME_KEY)) ;
                {
                    String filterGroupInfoName = in.nextString();
                    if (in.nextName().equals(REFINEMENT_VALUES_KEY)) {
                        in.beginObject();

//                    for (Map.Entry<String, JsonElement> refinementEntry : refinementValues.entrySet()) {
//                        JsonObject refinement = refinementEntry.getValue().getAsJsonObject();
//
//                        String linkText = refinement.get(LINK_KEY).getAsString();
//                        // Parse the id for the filter and assign it to a local variable to be used during
//                        // filter creation
//                        String id = linkText.substring(linkText.lastIndexOf(FILTER_DELIMITER) + 1);
//
//                        filters.add(new AutoValue_Filter(
//                                id,
//                                filterGroupId,
//                                refinement.get(TEXT_KEY).getAsString(),
//                                linkText));
//                    }

//                    String filterGroupInfoName = filterGroupJsonObject.get(FIELD_NAME_KEY).getAsString();

                        FilterGroupInfo filterGroupInfo = new AutoValue_FilterGroupInfo(filterGroupInfoName, filterGroupId);
                        FilterGroup filterGroup = new AutoValue_FilterGroup(filterGroupInfo, filters);

                        filterGroups.add(filterGroup);
                        in.endObject();
                    }
                }
            }
            in.endObject();
        }

        return filterGroups;
    }
}