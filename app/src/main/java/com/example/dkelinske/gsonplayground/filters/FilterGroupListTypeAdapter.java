package com.example.dkelinske.gsonplayground.filters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilterGroupListTypeAdapter extends TypeAdapter<List<FilterGroup>> {

    private static final String FIELD_NAME_KEY = "fieldName";
    private static final String REFINEMENT_VALUES_KEY = "refinementValues";
    private static final String LINK_KEY = "link";
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
            String filterGroupInfoName = null;
            in.beginObject();

            while (in.hasNext()) {
                if (in.nextName().equals(FIELD_NAME_KEY)) {
                    filterGroupInfoName = in.nextString();
                    if (in.nextName().equals(REFINEMENT_VALUES_KEY)) {
                        in.beginObject();

                        while (in.hasNext()) {
                            String filterId = in.nextName();
                            String linkText = null;
                            String refinement = null;
                            in.beginObject();

                            while (in.hasNext()) {
                                switch (in.nextName()) {
                                    case LINK_KEY:
                                        linkText = in.nextString();
                                        break;
                                    case TEXT_KEY:
                                        refinement = in.nextString();
                                        break;
                                    default:
                                        in.skipValue();
                                        break;
                                }
                            }

                            in.endObject();

                            filters.add(new AutoValue_Filter(
                                    filterId,
                                    filterGroupId,
                                    refinement,
                                    linkText));
                        }
                    }
                }
            }

            FilterGroupInfo filterGroupInfo = new AutoValue_FilterGroupInfo(filterGroupInfoName, filterGroupId);
            FilterGroup filterGroup = new AutoValue_FilterGroup(filterGroupInfo, filters);

            filterGroups.add(filterGroup);
            in.endObject();
            in.endObject();
        }
        return filterGroups;
    }
}
