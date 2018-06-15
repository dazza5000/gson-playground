package com.example.dkelinske.gsonplayground.searchv2;



import com.example.dkelinske.gsonplayground.filters.Filter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SearchRequestV2 implements Serializable {

    private int page = 1;
    private int pageSize = 20;
    private int maxMapResults = 50;
    private boolean mapSearch;
    private String query;
    private GeoCode southwestCorner;
    private GeoCode northeastCorner;
    private int minBeds;
    private int maxBeds;
    private int minSleeps;
    private int maxSleeps;
    private int minBath;
    private int maxBath;
    private int minPrice;
    private int maxPrice;
    private List<String> amenities;
    private Integer region;
    private String currency;
    private String sort;
    private List<String> listingIds;
    private String lbsUuid;
    private String searchURL;
    // Flag that will return unitMeasure in the response
    private boolean urgencyMessaging;
    private List<Filter> refineByFilters;

    public String getLbsUuid() {
        return lbsUuid;
    }

    public void setLbsUuid(String lbsUuid) {
        this.lbsUuid = lbsUuid;
    }

    public int getMinBeds() {
        return minBeds;
    }

    public void setMinBeds(int minBeds) {
        this.minBeds = minBeds;
    }

    public int getMaxBeds() {
        return maxBeds;
    }

    public void setMaxBeds(int maxBeds) {
        this.maxBeds = maxBeds;
    }

    public int getMinSleeps() {
        return minSleeps;
    }

    public void setMinSleeps(int minSleeps) {
        this.minSleeps = minSleeps;
    }

    public int getMaxSleeps() {
        return maxSleeps;
    }

    public void setMaxSleeps(int maxSleeps) {
        this.maxSleeps = maxSleeps;
    }

    public int getMinBath() {
        return minBath;
    }

    public void setMinBath(int minBath) {
        this.minBath = minBath;
    }

    public int getMaxBath() {
        return maxBath;
    }

    public void setMaxBath(int maxBath) {
        this.maxBath = maxBath;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public GeoCode getSouthwestCorner() {
        return southwestCorner;
    }

    public void setSouthwestCorner(GeoCode southwestCorner) {
        this.southwestCorner = southwestCorner;
    }

    public GeoCode getNortheastCorner() {
        return northeastCorner;
    }

    public void setNortheastCorner(GeoCode northeastCorner) {
        this.northeastCorner = northeastCorner;
    }

    public boolean isMapSearch() {
        return mapSearch;
    }

    public void setMapSearch(boolean mapSearch) {
        this.mapSearch = mapSearch;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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

    public int getMaxMapResults() {
        return maxMapResults;
    }

    public void setMaxMapResults(int maxMapResults) {
        this.maxMapResults = maxMapResults;
    }

    public List<String> getListingIds() {
        return listingIds;
    }

    public void setListingIds(List<String> listingIds) {
        this.listingIds = listingIds;
    }

    public boolean isUrgencyMessaging() {
        return urgencyMessaging;
    }

    public void setUrgencyMessaging(boolean urgencyMessaging) {
        this.urgencyMessaging = urgencyMessaging;
    }

    public String getSearchURL() { return searchURL; }

    public void setSearchURL(String searchURL) { this.searchURL = searchURL; }

    public List<Filter> getRefineByFilters() {
        return refineByFilters;
    }

    public void setRefineByFilters(List<Filter> refineByFilters) {
        this.refineByFilters = refineByFilters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchRequestV2 that = (SearchRequestV2) o;
        return page == that.page
                && pageSize == that.pageSize
                && maxMapResults == that.maxMapResults
                && mapSearch == that.mapSearch
                && minBeds == that.minBeds
                && maxBeds == that.maxBeds
                && minSleeps == that.minSleeps
                && maxSleeps == that.maxSleeps
                && minBath == that.minBath
                && maxBath == that.maxBath
                && minPrice == that.minPrice
                && maxPrice == that.maxPrice
                && urgencyMessaging == that.urgencyMessaging
                && Objects.equals(query, that.query)
                && Objects.equals(southwestCorner, that.southwestCorner)
                && Objects.equals(northeastCorner, that.northeastCorner)
                && Objects.equals(amenities, that.amenities)
                && Objects.equals(region, that.region)
                && Objects.equals(currency, that.currency)
                && Objects.equals(sort, that.sort)
                && Objects.equals(listingIds, that.listingIds)
                && Objects.equals(lbsUuid, that.lbsUuid)
                && Objects.equals(searchURL, that.searchURL)
                && Objects.equals(refineByFilters, that.refineByFilters);
    }

    @Override
    public int hashCode() {

        return Objects.hash(page, pageSize, maxMapResults, mapSearch, query, southwestCorner, northeastCorner, minBeds,
                maxBeds, minSleeps, maxSleeps, minBath, maxBath, minPrice, maxPrice, amenities, region, currency, sort, listingIds,
                lbsUuid, searchURL, urgencyMessaging, refineByFilters);
    }
}
