package com.example.dkelinske.gsonplayground.searchv2;

import java.io.Serializable;

/**
 * GeoCode represents latitude/longitude information and display options from a listing.
 */
public class GeoCode implements Serializable {

    private Double latitude;
    private Double longitude;
    private int maxZoomLevel;
    private int defaultZoomLevel;
    private boolean allowTravelersToZoom;
    private boolean showExactLocation;
    // this is driven by the "addressLatLngIsValid" on the underlying search GeoCode object
    private boolean hideMapOnListing;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getMaxZoomLevel() {
        return maxZoomLevel;
    }

    public void setMaxZoomLevel(int maxZoomLevel) {
        this.maxZoomLevel = maxZoomLevel;
    }

    public int getDefaultZoomLevel() {
        return defaultZoomLevel;
    }

    public void setDefaultZoomLevel(int defaultZoomLevel) {
        this.defaultZoomLevel = defaultZoomLevel;
    }

    public boolean isAllowTravelersToZoom() {
        return allowTravelersToZoom;
    }

    public void setAllowTravelersToZoom(boolean allowTravelersToZoom) {
        this.allowTravelersToZoom = allowTravelersToZoom;
    }

    public boolean isShowExactLocation() {
        return showExactLocation;
    }

    public void setShowExactLocation(boolean showExactLocation) {
        this.showExactLocation = showExactLocation;
    }

    public boolean isHideMapOnListing() {
        return hideMapOnListing;
    }

    public void setHideMapOnListing(boolean hideMapOnListing) {
        this.hideMapOnListing = hideMapOnListing;
    }

    public boolean isInvalid() {
        return latitude < -90.0 || latitude > 90.0 || longitude < -180.0 || longitude > 180.0
                || (latitude == 0.0 && longitude == 0.0);
    }

    public String getUri() {
        return "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;
    }
}
