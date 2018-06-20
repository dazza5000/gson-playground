package com.example.dkelinske.gsonplayground.searchv2;

import com.example.dkelinske.gsonplayground.filters.FilterGroup;
import com.example.dkelinske.gsonplayground.filters.FilterGroupListParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.List;

public class CustomizedTypeAdapterFactory implements TypeAdapterFactory {

    private static final String REFINEMENTS_KEY = "refinements";

    private final Class<SearchResultV2> customizedClass = SearchResultV2.class;
    private final FilterGroupListParser filterGroupListParser = new FilterGroupListParser();

    public CustomizedTypeAdapterFactory() {}

    @SuppressWarnings("unchecked") // we use a runtime check to guarantee that 'C' and 'T' are equal
    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        return type.getRawType() == customizedClass
                ? (TypeAdapter<T>) customizeMyClassAdapter(gson, (TypeToken<SearchResultV2>) type)
                : null;
    }

    private TypeAdapter<SearchResultV2> customizeMyClassAdapter(final Gson gson, TypeToken<SearchResultV2> type) {
        final TypeAdapter<SearchResultV2> delegate = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
        return new TypeAdapter<SearchResultV2>() {
            @Override public void write(JsonWriter out, SearchResultV2 value) throws IOException {
                JsonElement tree = delegate.toJsonTree(value);
                elementAdapter.write(out, tree);
            }
            @Override public SearchResultV2 read(JsonReader in) throws IOException {
                JsonElement tree = elementAdapter.read(in);
                SearchResultV2 searchResultV2 = delegate.fromJsonTree(tree);
                List<FilterGroup> filterGroups = gson.newBuilder().registerTypeAdapter(customizedClass, filterGroupListParser).create().fromJson();
                searchResultV2 = searchResultV2.toBuilder().filterGroups(filterGroups).build();
                return  searchResultV2;
            }
        };
    }
}