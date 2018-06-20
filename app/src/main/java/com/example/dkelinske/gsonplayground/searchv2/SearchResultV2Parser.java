package com.example.dkelinske.gsonplayground.searchv2;

import com.example.dkelinske.gsonplayground.filters.FilterGroup;
import com.example.dkelinske.gsonplayground.filters.FilterGroupListParser;
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

    private static final String HIT_COUNT_KEY = "hitCount";
    private static final String PAGE_KEY = "page";
    private static final String PAGE_COUNT_KEY = "pageCount";
    private static final String PAGE_SIZE_KEY = "pageSize";
    private static final String MAP_VIEWPORT_KEY = "mapViewport";
    private static final String REFINEMENTS_KEY = "refinements";
    private static final String AB_TEST_INFOS_KEY = "abTestInfos";
    private static final String REGION_PATH_HIERARCHY_KEY = "regionPathHierarchy";
    private static final String HITS_KEY = "hits";

    private final Type filterListType;
    private final Type mapViewportType;
    private final Type abTestInfosType;
    private final Type hitsListType;
    private final FilterGroupListParser filterGroupListParser;

    public SearchResultV2Parser() {
        this.filterGroupListParser = new FilterGroupListParser();
        this.filterListType = new TypeToken<List<FilterGroup>>(){}.getType();
        this.mapViewportType = new TypeToken<MapViewPort>(){}.getType();
        this.abTestInfosType = new TypeToken<List<ABTestInfo>>(){}.getType();
        this.hitsListType = new TypeToken<List<Hit>>(){}.getType();
    }

    @Override
    public SearchResultV2 deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject searchResultsObject = json.getAsJsonObject();
        JsonElement filterGroupsElement = searchResultsObject.get(REFINEMENTS_KEY);

        MapViewPort mapViewPort = context.deserialize(searchResultsObject.get(MAP_VIEWPORT_KEY), mapViewportType);
        List<FilterGroup> filterGroups = filterGroupListParser.deserialize(filterGroupsElement, filterListType, context);
        List<Hit> hits = context.deserialize(searchResultsObject.get(HITS_KEY), hitsListType);
        List<ABTestInfo> abTestInfos = context.deserialize(searchResultsObject.get(AB_TEST_INFOS_KEY), abTestInfosType);

        return SearchResultV2.builder()
                .hitCount(searchResultsObject.get(HIT_COUNT_KEY).getAsInt())
                .page(searchResultsObject.get(PAGE_KEY).getAsInt())
                .pageCount(searchResultsObject.get(PAGE_COUNT_KEY).getAsInt())
                .pageSize(searchResultsObject.get(PAGE_SIZE_KEY).getAsInt())
                .mapViewport(mapViewPort)
                .filterGroups(filterGroups)
                .hits(hits)
                .abTestInfos(abTestInfos)
                .regionPathHierarchy(searchResultsObject.get(REGION_PATH_HIERARCHY_KEY).getAsString())
                .build();
    }
}