package com.peter.fourpicsonewordcheats.event;

/**
 * Created by Peter on 6/6/2014.
 */
public class SearchByDescriptionEvent {
    public SearchByDescriptionEvent(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
