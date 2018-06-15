package com.example.dkelinske.gsonplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dkelinske.gsonplayground.filters.Filter;
import com.example.dkelinske.gsonplayground.filters.FilterGroup;
import com.example.dkelinske.gsonplayground.filters.FilterGroupInfo;
import com.example.dkelinske.gsonplayground.filters.FilterGroupParser;
import com.example.dkelinske.gsonplayground.searchv2.SearchResultV2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String FIELD_NAME_KEY = "fieldName";
    private static final String REFINEMENTS_KEY = "refinements";
    private static final String REFINEMENT_VALUES_KEY = "refinementValues";
    private static final String LINK_KEY = "link";
    private static final String FILTER_DELIMITER = ":";
    private static final String TEXT_KEY = "text";

    String searchResponseJson = "{\"hitCount\":29,\"page\":0,\"pageCount\":0,\"pageSize\":0,\"fromRecord\":0,\"toRecord\":0,\"mapViewport\":{\"southwest\":{\"latitude\":30.07569,\"longitude\":-98.026144},\"northeast\":{\"latitude\":30.519484,\"longitude\":-97.541669}},\"refinements\":{\"1\":{\"fieldName\":\"Features & amenities\",\"refinementValues\":{\"22\":{\"text\":\"Patio or deck\",\"link\":\"filter:22\",\"count\":22},\"23\":{\"text\":\"Pool\",\"link\":\"filter:23\",\"count\":29},\"24\":{\"text\":\"Private pool\",\"link\":\"filter:24\",\"count\":11},\"25\":{\"text\":\"TV\",\"link\":\"filter:25\",\"count\":28},\"10\":{\"text\":\"Heated/indoor pool\",\"link\":\"filter:10\",\"count\":29},\"11\":{\"text\":\"Heating\",\"link\":\"filter:11\",\"count\":24},\"12\":{\"text\":\"Hot tub\",\"link\":\"filter:12\",\"count\":23},\"13\":{\"text\":\"Internet/WiFi\",\"link\":\"filter:13\",\"count\":29},\"14\":{\"text\":\"Iron & ironing board\",\"link\":\"filter:14\",\"count\":25},\"15\":{\"text\":\"Kids' high chair\",\"link\":\"filter:15\",\"count\":6},\"16\":{\"text\":\"King-sized bed\",\"link\":\"filter:16\",\"count\":9},\"17\":{\"text\":\"Laundry machines\",\"link\":\"filter:17\",\"count\":27},\"18\":{\"text\":\"Microwave\",\"link\":\"filter:18\",\"count\":29},\"19\":{\"text\":\"Outdoor grill/BBQ\",\"link\":\"filter:19\",\"count\":25},\"1\":{\"text\":\"Air conditioning\",\"link\":\"filter:1\",\"count\":29},\"2\":{\"text\":\"Balcony\",\"link\":\"filter:2\",\"count\":7},\"3\":{\"text\":\"Bed linens provided\",\"link\":\"filter:3\",\"count\":29},\"4\":{\"text\":\"Crib\",\"link\":\"filter:4\",\"count\":1},\"5\":{\"text\":\"Dishwasher\",\"link\":\"filter:5\",\"count\":24},\"6\":{\"text\":\"DVD player\",\"link\":\"filter:6\",\"count\":19},\"7\":{\"text\":\"Fireplace\",\"link\":\"filter:7\",\"count\":16},\"8\":{\"text\":\"Garden or backyard\",\"link\":\"filter:8\",\"count\":13},\"9\":{\"text\":\"Gym/fitness equipment\",\"link\":\"filter:9\",\"count\":13},\"20\":{\"text\":\"Oven/stove\",\"link\":\"filter:20\",\"count\":28},\"21\":{\"text\":\"Parking available\",\"link\":\"filter:21\",\"count\":28}}},\"2\":{\"fieldName\":\"House rules\",\"refinementValues\":{\"26\":{\"text\":\"Events allowed\",\"link\":\"filter:26\",\"count\":8},\"28\":{\"text\":\"Smoking allowed\",\"link\":\"filter:28\",\"count\":0}}},\"booking_title\":{\"fieldName\":\"Booking Options\",\"refinementValues\":{\"online_booking\":{\"text\":\"24 Hour Confirmation\",\"link\":\"filter:90\",\"count\":29},\"instant_booking\":{\"text\":\"Instant Confirmation\",\"link\":\"filter:89\",\"count\":2}}},\"amenities_title\":{\"fieldName\":\"Properties good for\",\"refinementValues\":{\"suitability_pets_considered\":{\"text\":\"Pets\",\"link\":\"filter:27\",\"count\":0},\"44\":{\"text\":\"Luxury\",\"link\":\"filter:44\",\"count\":0},\"10001\":{\"text\":\"Stays of 3 nights or less\",\"link\":\"filter:10001\",\"count\":0},\"10003\":{\"text\":\"Group travel (no kids)\",\"link\":\"filter:10003\",\"count\":0},\"43\":{\"text\":\"Families with kids\",\"link\":\"filter:43\",\"count\":0}}},\"3\":{\"fieldName\":\"Location\",\"refinementValues\":{\"33\":{\"text\":\"Downtown\",\"link\":\"filter:33\",\"count\":1},\"34\":{\"text\":\"Golf course\",\"link\":\"filter:34\",\"count\":1},\"35\":{\"text\":\"Lake\",\"link\":\"filter:35\",\"count\":11},\"36\":{\"text\":\"Mountains\",\"link\":\"filter:36\",\"count\":3},\"37\":{\"text\":\"Ocean\",\"link\":\"filter:37\",\"count\":1},\"38\":{\"text\":\"Rural\",\"link\":\"filter:38\",\"count\":2},\"39\":{\"text\":\"Ski-in/ski-out\",\"link\":\"filter:39\",\"count\":0},\"91\":{\"text\":\"Oceanfront\",\"link\":\"filter:91\",\"count\":0},\"40\":{\"text\":\"Town\",\"link\":\"filter:40\",\"count\":1},\"30\":{\"text\":\"Beach\",\"link\":\"filter:30\",\"count\":2},\"41\":{\"text\":\"Village\",\"link\":\"filter:41\",\"count\":0},\"42\":{\"text\":\"Waterfront\",\"link\":\"filter:42\",\"count\":8},\"31\":{\"text\":\"Beach view\",\"link\":\"filter:31\",\"count\":1},\"32\":{\"text\":\"Beachfront\",\"link\":\"filter:32\",\"count\":1}}},\"5\":{\"fieldName\":\"Nearby activities\",\"refinementValues\":{\"55\":{\"text\":\"Skiing/snowboarding\",\"link\":\"filter:55\",\"count\":1},\"45\":{\"text\":\"Amusement/theme parks\",\"link\":\"filter:45\",\"count\":3},\"56\":{\"text\":\"Tennis\",\"link\":\"filter:56\",\"count\":19},\"46\":{\"text\":\"Cycling\",\"link\":\"filter:46\",\"count\":9},\"57\":{\"text\":\"Watersports\",\"link\":\"filter:57\",\"count\":19},\"47\":{\"text\":\"Fishing\",\"link\":\"filter:47\",\"count\":13},\"58\":{\"text\":\"Winery/brewery tours\",\"link\":\"filter:58\",\"count\":10},\"48\":{\"text\":\"Golfing\",\"link\":\"filter:48\",\"count\":12},\"49\":{\"text\":\"Hiking\",\"link\":\"filter:49\",\"count\":12},\"50\":{\"text\":\"Horseback riding\",\"link\":\"filter:50\",\"count\":7},\"51\":{\"text\":\"Museums & galleries\",\"link\":\"filter:51\",\"count\":9},\"52\":{\"text\":\"Rock/mountain climbing\",\"link\":\"filter:52\",\"count\":2},\"53\":{\"text\":\"Scuba diving/snorkeling\",\"link\":\"filter:53\",\"count\":3},\"54\":{\"text\":\"Shopping & relaxation\",\"link\":\"filter:54\",\"count\":12}}},\"6\":{\"fieldName\":\"Property type\",\"refinementValues\":{\"66\":{\"text\":\"Chalet\",\"link\":\"filter:66\",\"count\":0},\"67\":{\"text\":\"Chateau/country house\",\"link\":\"filter:67\",\"count\":1},\"69\":{\"text\":\"Cottage\",\"link\":\"filter:69\",\"count\":3},\"92\":{\"text\":\"Apartment/condo\",\"link\":\"filter:92\",\"count\":10},\"70\":{\"text\":\"Estate\",\"link\":\"filter:70\",\"count\":0},\"71\":{\"text\":\"Farmhouse\",\"link\":\"filter:71\",\"count\":0},\"72\":{\"text\":\"Guest house\",\"link\":\"filter:72\",\"count\":0},\"73\":{\"text\":\"Hotel\",\"link\":\"filter:73\",\"count\":0},\"74\":{\"text\":\"House\",\"link\":\"filter:74\",\"count\":13},\"75\":{\"text\":\"Houseboat\",\"link\":\"filter:75\",\"count\":0},\"76\":{\"text\":\"Lodge\",\"link\":\"filter:76\",\"count\":0},\"77\":{\"text\":\"Mill\",\"link\":\"filter:77\",\"count\":0},\"78\":{\"text\":\"Mobile home/caravan\",\"link\":\"filter:78\",\"count\":0},\"79\":{\"text\":\"Resort\",\"link\":\"filter:79\",\"count\":0},\"80\":{\"text\":\"Studio\",\"link\":\"filter:80\",\"count\":0},\"81\":{\"text\":\"Tower\",\"link\":\"filter:81\",\"count\":0},\"82\":{\"text\":\"Townhouse\",\"link\":\"filter:82\",\"count\":0},\"60\":{\"text\":\"Barn\",\"link\":\"filter:60\",\"count\":0},\"83\":{\"text\":\"Villa\",\"link\":\"filter:83\",\"count\":5},\"61\":{\"text\":\"Bed & breakfast\",\"link\":\"filter:61\",\"count\":1},\"62\":{\"text\":\"Boat\",\"link\":\"filter:62\",\"count\":0},\"84\":{\"text\":\"Yacht\",\"link\":\"filter:84\",\"count\":0},\"63\":{\"text\":\"Bungalow\",\"link\":\"filter:63\",\"count\":3},\"64\":{\"text\":\"Cabin\",\"link\":\"filter:64\",\"count\":3},\"65\":{\"text\":\"Castle\",\"link\":\"filter:65\",\"count\":0}}},\"7\":{\"fieldName\":\"Safety & accessibility\",\"refinementValues\":{\"85\":{\"text\":\"Elevator\",\"link\":\"filter:85\",\"count\":7},\"86\":{\"text\":\"Low-allergen environment\",\"link\":\"filter:86\",\"count\":26},\"87\":{\"text\":\"Wheelchair accessible\",\"link\":\"filter:87\",\"count\":5}}},\"8\":{\"fieldName\":\"Services\",\"refinementValues\":{\"88\":{\"text\":\"Housekeeping\",\"link\":\"filter:88\",\"count\":5}}}},\"hits\":[],\"isLastSearchablePage\":false,\"abTestInfos\":[{\"abTestId\":1119,\"abTestName\":\"Filter Service A/B Squash test\",\"bucketName\":\"1\",\"bucketScoreName\":null},{\"abTestId\":null,\"abTestName\":null,\"bucketName\":null,\"bucketScoreName\":\"Ff15RankingService\"},{\"abTestId\":null,\"abTestName\":null,\"bucketName\":null,\"bucketScoreName\":\"DefaultLBS\"},{\"abTestId\":1019,\"abTestName\":\"AA Test\",\"bucketName\":\"0\",\"bucketScoreName\":null}],\"regionPathHierarchy\":\"usa:texas:texas hill country:austin\",\"searchAvailability\":null,\"lastSearchablePage\":false}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<List<FilterGroup>>(){}.getType(), new FilterGroupParser())
                .create();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(searchResponseJson).getAsJsonObject();
//        JsonObject refinementObject = jsonObject.get(REFINEMENTS_KEY).getAsJsonObject();
////        Log.e("darran", "the refinement object member count is: "+refinementObject.keySet().size());
//        List<FilterGroup> filterGroups = new ArrayList<>();
//        for (String key : refinementObject.keySet()) {
////            Log.e("darran", "This key is: "+key);
//
//            List<Filter> filters = new ArrayList<>();
//
//            JsonObject filterGroupJsobObject = refinementObject.get(key).getAsJsonObject();
//            JsonObject refinementValues = filterGroupJsobObject.getAsJsonObject(REFINEMENT_VALUES_KEY);
//            for (String refinementValueKey : refinementValues.keySet()) {
//                JsonObject refinement = refinementValues.getAsJsonObject(refinementValueKey);
//
//                String linkText = refinement.get(LINK_KEY).getAsString() ;
//                String id = linkText.substring(linkText.lastIndexOf(FILTER_DELIMITER) + 1);
//
//                filters.add(Filter.create(
//                        id,
//                        key,
//                        refinement.get(TEXT_KEY).getAsString(),
//                        linkText));
//            }
//
//
//            String filterGroupInfoName = refinementObject.get(key).getAsJsonObject().get(FIELD_NAME_KEY).getAsString();
//
////            Log.e("darran", "The field name is: " + filterGroupInfoName);
//
//            FilterGroupInfo filterGroupInfo = FilterGroupInfo.create(filterGroupInfoName, key);
//            FilterGroup filterGroup =
//                    FilterGroup.create(filterGroupInfo, filters);
//            filterGroups.add(filterGroup);
//        }
//
////        Log.e("darran", "The filter group count is: "+filterGroups.size());

        SearchResultV2 searchResultV2 = gson.fromJson(jsonObject, SearchResultV2.class);

        Log.e("darran", "The search results has this hitCount " + searchResultV2.getHitCount());
    }
}
