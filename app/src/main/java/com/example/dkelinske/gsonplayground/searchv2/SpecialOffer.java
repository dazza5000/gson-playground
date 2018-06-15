package com.example.dkelinske.gsonplayground.searchv2;

import java.io.Serializable;

/**
 * Created by bgriffey on 3/4/16.
 */
public class SpecialOffer implements Serializable {

    private String title;
    private boolean lastMinute;
    private String note;

    public SpecialOffer() {
    }

    public boolean isLastMinute() {
        return lastMinute;
    }

    public void setLastMinute(boolean lastMinute) {
        this.lastMinute = lastMinute;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
