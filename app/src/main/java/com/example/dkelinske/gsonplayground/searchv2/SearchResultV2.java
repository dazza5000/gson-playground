package com.example.dkelinske.gsonplayground.searchv2;


import com.example.dkelinske.gsonplayground.filters.FilterGroup;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SearchResultV2 implements Serializable {

    private int hitCount;
    private int page;
    private int pageSize;
    private int pageCount;
    private List<Hit> hits;
    private List<ABTestInfo> abTestInfos;
    private SearchRequestV2 searchRequestData;
    private WebLinkSearchRequest searchRequest;
    private String regionPathHierarchy;
    private MapViewPort mapViewport;
    private List<FilterGroup> filterGroups;

    public SearchResultV2() {
    }

    public List<ABTestInfo> getAbTestInfos() {
        return abTestInfos;
    }

    public void setAbTestInfos(List<ABTestInfo> abTestInfos) {
        this.abTestInfos = abTestInfos;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    public String getRegionPathHierarchy() {
        return regionPathHierarchy;
    }

    public void setRegionPathHierarchy(String regionPathHierarchy) {
        this.regionPathHierarchy = regionPathHierarchy;
    }

    public SearchRequestV2 getSearchRequestData() {
        return searchRequestData;
    }

    public void setSearchRequestData(SearchRequestV2 searchRequestData) {
        this.searchRequestData = searchRequestData;
    }

    public MapViewPort getMapViewport() {
        return mapViewport;
    }

    public WebLinkSearchRequest getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(WebLinkSearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }

    public List<FilterGroup> getFilterGroups() {
        return filterGroups;
    }

    public void setFilterGroups(List<FilterGroup> filterGroups) {
        this.filterGroups = filterGroups;
    }

    // latitude and longitude
    // https://wiki.homeawaycorp.com/display/arch/ADL+Spec+-+Component-Specific+Fields+-+Search+-+v1.6.0
    public Double getLatitudeCenter() {
        if (mapViewport.getNortheast() != null
                && mapViewport.getNortheast().getLatitude() != null
                && mapViewport.getSouthwest() != null
                && mapViewport.getSouthwest().getLatitude() != null) {
            return (mapViewport.getNortheast().getLatitude() + mapViewport.getSouthwest().getLatitude()) / 2;
        }
        return null;
    }

    public Double getLongitudeCenter() {
        if (mapViewport.getNortheast() != null
                && mapViewport.getNortheast().getLongitude() != null
                && mapViewport.getSouthwest() != null
                && mapViewport.getSouthwest().getLongitude() != null) {
            return (mapViewport.getNortheast().getLongitude() + mapViewport.getSouthwest().getLongitude()) / 2;
        }
        return null;
    }
}
