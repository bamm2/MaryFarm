package com.numberONE.maryfarm.MyfarmProfile;

public class FarmFeedData {

    private int farm_feed_main_photo;
    private int farm_feed_sub1_photo;
    private int farm_feed_sub2_photo;
    private String farm_feed_title;
    private String farm_feed_time;
    private String farm_plant_date;

    public FarmFeedData(int farm_feed_main_photo, int farm_feed_sub1_photo, int farm_feed_sub2_photo, String farm_feed_title, String farm_feed_time, String farm_plant_date) {
        this.farm_feed_main_photo = farm_feed_main_photo;
        this.farm_feed_sub1_photo = farm_feed_sub1_photo;
        this.farm_feed_sub2_photo = farm_feed_sub2_photo;
        this.farm_feed_title = farm_feed_title;
        this.farm_feed_time = farm_feed_time;
        this.farm_plant_date = farm_plant_date;
    }

    public int getFarm_feed_main_photo() {
        return farm_feed_main_photo;
    }

    public void setFarm_feed_main_photo(int farm_feed_main_photo) {
        this.farm_feed_main_photo = farm_feed_main_photo;
    }

    public int getFarm_feed_sub1_photo() {
        return farm_feed_sub1_photo;
    }

    public void setFarm_feed_sub1_photo(int farm_feed_sub1_photo) {
        this.farm_feed_sub1_photo = farm_feed_sub1_photo;
    }

    public int getFarm_feed_sub2_photo() {
        return farm_feed_sub2_photo;
    }

    public void setFarm_feed_sub2_photo(int farm_feed_sub2_photo) {
        this.farm_feed_sub2_photo = farm_feed_sub2_photo;
    }

    public String getFarm_feed_title() {
        return farm_feed_title;
    }

    public void setFarm_feed_title(String farm_feed_title) {
        this.farm_feed_title = farm_feed_title;
    }

    public String getFarm_feed_time() {
        return farm_feed_time;
    }

    public void setFarm_feed_time(String farm_feed_time) {
        this.farm_feed_time = farm_feed_time;
    }

    public String getFarm_plant_date() {
        return farm_plant_date;
    }

    public void setFarm_plant_date(String farm_plant_date) {
        this.farm_plant_date = farm_plant_date;
    }
}
