package com.example.dkelinske.gsonplayground.searchv2;


import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.example.dkelinske.gsonplayground.filters.FilterGroup;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.Serializable;
import java.util.List;

@AutoValue
public abstract class SearchResultV2 implements Parcelable {

    public abstract int hitCount();
    public abstract int page();
    public abstract int pageSize();
    public abstract int pageCount();
    @Nullable public abstract List<Hit> hits();
    @Nullable public abstract MapViewPort mapViewport();
    @Nullable public abstract List<FilterGroup> filterGroups();
    @Nullable public abstract List<ABTestInfo> abTestInfos();
    @Nullable public abstract String regionPathHierarchy();
    @Nullable public abstract SearchRequestV2 searchRequestData();
    @Nullable public abstract WebLinkSearchRequest searchRequest();

    // latitude and longitude
    // https://wiki.homeawaycorp.com/display/arch/ADL+Spec+-+Component-Specific+Fields+-+Search+-+v1.6.0
    public Double getLatitudeCenter() {
        if (mapViewport().getNortheast() != null
                && mapViewport().getNortheast().getLatitude() != null
                && mapViewport().getSouthwest() != null
                && mapViewport().getSouthwest().getLatitude() != null) {
            return (mapViewport().getNortheast().getLatitude() + mapViewport().getSouthwest().getLatitude()) / 2;
        }
        return null;
    }

    public Double getLongitudeCenter() {
        if (mapViewport().getNortheast() != null
                && mapViewport().getNortheast().getLongitude() != null
                && mapViewport().getSouthwest() != null
                && mapViewport().getSouthwest().getLongitude() != null) {
            return (mapViewport().getNortheast().getLongitude() + mapViewport().getSouthwest().getLongitude()) / 2;
        }
        return null;
    }

    public static TypeAdapter<SearchResultV2> typeAdapter(Gson gson) {
        return new AutoValue_SearchResultV2.GsonTypeAdapter(gson);
    }

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_SearchResultV2.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder hitCount(int hitCount);

        public abstract Builder page(int page);

        public abstract Builder pageSize(int pageSize);

        public abstract Builder pageCount(int pageCount);

        public abstract Builder hits(List<Hit> hits);

        public abstract Builder abTestInfos(List<ABTestInfo> abTestInfos);

        public abstract Builder searchRequestData(SearchRequestV2 searchRequestData);

        public abstract Builder searchRequest(WebLinkSearchRequest searchRequest);

        public abstract Builder regionPathHierarchy(String regionPathHierarchy);

        public abstract Builder mapViewport(MapViewPort mapViewport);

        public abstract Builder filterGroups(List<FilterGroup> filterGroups);

        public abstract SearchResultV2 build();

    }
}
