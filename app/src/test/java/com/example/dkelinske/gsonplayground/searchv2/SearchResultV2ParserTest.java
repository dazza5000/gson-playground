package com.example.dkelinske.gsonplayground.searchv2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchResultV2ParserTest {

    private static final String FEATURES_AND_AMENITIES = "Features & amenities";

    @Test
    public void testSearchResultV2deserialize() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(SearchResultV2.class, new SearchResultV2Parser())
                .create();
        SearchResultV2 searchResultV2 = gson.fromJson(getSearchResultV2JsonString(), SearchResultV2.class);
        Assert.assertEquals(270, searchResultV2.hitCount());
        Assert.assertEquals(1, searchResultV2.filterGroups().size());
        Assert.assertEquals(FEATURES_AND_AMENITIES, searchResultV2.filterGroups().get(0).groupInfo().name());
        Assert.assertEquals(25, searchResultV2.filterGroups().get(0).filters().size());
        Assert.assertEquals(5, searchResultV2.abTestInfos().size());
    }

    private String getSearchResultV2JsonString() {
        return "{\n" +
                "\t\t\"hitCount\": 270,\n" +
                "\t\t\"page\": 0,\n" +
                "\t\t\"pageCount\": 0,\n" +
                "\t\t\"pageSize\": 0,\n" +
                "\t\t\"fromRecord\": 0,\n" +
                "\t\t\"toRecord\": 0,\n" +
                "\t\t\"mapViewport\": {\n" +
                "\t\t\t\"southwest\": {\n" +
                "\t\t\t\t\"latitude\": 30.07569,\n" +
                "\t\t\t\t\"longitude\": -98.026144\n" +
                "\t\t\t},\n" +
                "\t\t\t\"northeast\": {\n" +
                "\t\t\t\t\"latitude\": 30.519484,\n" +
                "\t\t\t\t\"longitude\": -97.541669\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t\"refinements\": {\n" +
                "\t\t\t\"1\": {\n" +
                "\t\t\t\t\"fieldName\": \"" +FEATURES_AND_AMENITIES +"\",\n" +
                "\t\t\t\t\"refinementValues\": {\n" +
                "\t\t\t\t\t\"1\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Air conditioning\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:1\",\n" +
                "\t\t\t\t\t\t\"count\": 266\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"2\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Balcony\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:2\",\n" +
                "\t\t\t\t\t\t\"count\": 102\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"3\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Bed linens provided\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:3\",\n" +
                "\t\t\t\t\t\t\"count\": 257\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"4\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Crib\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:4\",\n" +
                "\t\t\t\t\t\t\"count\": 5\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"5\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Dishwasher\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:5\",\n" +
                "\t\t\t\t\t\t\"count\": 224\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"6\": {\n" +
                "\t\t\t\t\t\t\"text\": \"DVD player\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:6\",\n" +
                "\t\t\t\t\t\t\"count\": 122\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"7\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Fireplace\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:7\",\n" +
                "\t\t\t\t\t\t\"count\": 114\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"8\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Garden or backyard\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:8\",\n" +
                "\t\t\t\t\t\t\"count\": 82\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"9\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Gym/fitness equipment\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:9\",\n" +
                "\t\t\t\t\t\t\"count\": 58\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"10\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Heated/indoor pool\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:10\",\n" +
                "\t\t\t\t\t\t\"count\": 32\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"11\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Heating\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:11\",\n" +
                "\t\t\t\t\t\t\"count\": 228\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"12\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Hot tub\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:12\",\n" +
                "\t\t\t\t\t\t\"count\": 88\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"13\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Internet/WiFi\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:13\",\n" +
                "\t\t\t\t\t\t\"count\": 256\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"14\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Iron & ironing board\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:14\",\n" +
                "\t\t\t\t\t\t\"count\": 175\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"15\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Kids' high chair\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:15\",\n" +
                "\t\t\t\t\t\t\"count\": 30\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"16\": {\n" +
                "\t\t\t\t\t\t\"text\": \"King-sized bed\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:16\",\n" +
                "\t\t\t\t\t\t\"count\": 75\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"17\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Laundry machines\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:17\",\n" +
                "\t\t\t\t\t\t\"count\": 241\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"18\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Microwave\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:18\",\n" +
                "\t\t\t\t\t\t\"count\": 247\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"19\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Outdoor grill/BBQ\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:19\",\n" +
                "\t\t\t\t\t\t\"count\": 167\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"20\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Oven/stove\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:20\",\n" +
                "\t\t\t\t\t\t\"count\": 228\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"21\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Parking available\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:21\",\n" +
                "\t\t\t\t\t\t\"count\": 218\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"22\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Patio or deck\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:22\",\n" +
                "\t\t\t\t\t\t\"count\": 179\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"23\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Pool\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:23\",\n" +
                "\t\t\t\t\t\t\"count\": 270\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"24\": {\n" +
                "\t\t\t\t\t\t\"text\": \"Private pool\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:24\",\n" +
                "\t\t\t\t\t\t\"count\": 55\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\t\"25\": {\n" +
                "\t\t\t\t\t\t\"text\": \"TV\",\n" +
                "\t\t\t\t\t\t\"link\": \"filter:25\",\n" +
                "\t\t\t\t\t\t\"count\": 253\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "},\n" +
                "\t\t\"hits\": [],\n" +
                "\t\t\"isLastSearchablePage\": false,\n" +
                "\t\t\"abTestInfos\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"abTestId\": 1119,\n" +
                "\t\t\t\t\"abTestName\": \"Filter Service A/B Squash test\",\n" +
                "\t\t\t\t\"bucketName\": \"1\",\n" +
                "\t\t\t\t\"bucketScoreName\": null\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"abTestId\": null,\n" +
                "\t\t\t\t\"abTestName\": null,\n" +
                "\t\t\t\t\"bucketName\": null,\n" +
                "\t\t\t\t\"bucketScoreName\": \"Ff15RankingService\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"abTestId\": null,\n" +
                "\t\t\t\t\"abTestName\": null,\n" +
                "\t\t\t\t\"bucketName\": null,\n" +
                "\t\t\t\t\"bucketScoreName\": \"DefaultLBS\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"abTestId\": 1019,\n" +
                "\t\t\t\t\"abTestName\": \"AA Test\",\n" +
                "\t\t\t\t\"bucketName\": \"1\",\n" +
                "\t\t\t\t\"bucketScoreName\": null\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"abTestId\": 1091,\n" +
                "\t\t\t\t\"abTestName\": \"Naughty List\",\n" +
                "\t\t\t\t\"bucketName\": \"1\",\n" +
                "\t\t\t\t\"bucketScoreName\": null\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"regionPathHierarchy\": \"usa:texas:texas hill country:austin\",\n" +
                "\t\t\"searchAvailability\": null,\n" +
                "\t\t\"lastSearchablePage\": false\n" +
                "\t}";
    }
}