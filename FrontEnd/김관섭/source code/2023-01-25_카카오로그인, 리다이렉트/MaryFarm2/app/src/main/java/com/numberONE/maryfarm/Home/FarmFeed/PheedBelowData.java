package com.numberONE.maryfarm.Home.FarmFeed;

public class PheedBelowData {
    String name;
    String message;
    int resourceId;

    public PheedBelowData(String name, String message, int resourceId) {
        this.name = name;
        this.message = message;
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
