package com.example.dkelinske.gsonplayground.searchv2;

import java.io.Serializable;

public class ABTestInfo implements Serializable {

    private Integer abTestId;
    private String abTestName;
    private String bucketName;
    private String bucketScoreName;

    public Integer getAbTestId() {
        return abTestId;
    }

    public void setAbTestId(Integer abTestId) {
        this.abTestId = abTestId;
    }

    public String getAbTestName() {
        return abTestName;
    }

    public void setAbTestName(String abTestName) {
        this.abTestName = abTestName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketScoreName() {
        return bucketScoreName;
    }

    public void setBucketScoreName(String bucketScoreName) {
        this.bucketScoreName = bucketScoreName;
    }
}
