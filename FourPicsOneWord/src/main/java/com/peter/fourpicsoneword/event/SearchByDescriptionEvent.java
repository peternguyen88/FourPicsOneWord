package com.peter.fourpicsoneword.event;

/**
 * Created by Peter on 6/6/2014.
 */
public class SearchByDescriptionEvent {
    private String description;

    public SearchByDescriptionEvent(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
