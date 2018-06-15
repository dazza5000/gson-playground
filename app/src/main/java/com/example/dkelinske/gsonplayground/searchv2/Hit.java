package com.example.dkelinske.gsonplayground.searchv2;


import java.io.Serializable;

public class Hit implements Serializable {

    private boolean bearStayed;
    private String galleryUrl;
    private String[] regions;
    private Integer imageCount;
    private String regionPathHierarchy;
    private String unitName;
    private SpecialOffer specialOffer;

    //bgriffey - new mobile graphql fields
    private String mobileGalleryUrl;


    public Hit() {
    }


    public String getGalleryUrl() {
        //bgriffey - this is backwards compatability layer for the new graphql field that has
        //specificially to do with the a new field that might not be available on disk
        if (mobileGalleryUrl != null) {
            return mobileGalleryUrl;
        } else {
            return this.galleryUrl;
        }
    }

    public String getMobileGalleryUrl() {
        return mobileGalleryUrl;
    }


    public void setGalleryUrl(String galleryUrl) {
        this.galleryUrl = galleryUrl;
    }

    public String[] getRegions() {
        return this.regions;
    }

    public void setRegions(String[] regions) {
        this.regions = regions;
    }


    public boolean isBearStayed() {
        return this.bearStayed;
    }

    public void setBearStayed(boolean bearStayed) {
        this.bearStayed = bearStayed;
    }

    @Deprecated
    public int getNumPhotos() {
        return imageCount != null ? imageCount : 0;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public String getRegionPathHierarchy() {
        return regionPathHierarchy;
    }

    public void setRegionPathHierarchy(String regionPathHierarchy) {
        this.regionPathHierarchy = regionPathHierarchy;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public SpecialOffer getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(SpecialOffer specialOffer) {
        this.specialOffer = specialOffer;
    }
}
