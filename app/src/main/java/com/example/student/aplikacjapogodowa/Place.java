package com.example.student.aplikacjapogodowa;

/**
 * Created by asiachwal on 02.01.2018.
 */

public class Place {
    private String placeName;
    private int temperature;
    private String information;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Place(String name, String inf){
        placeName = name;
        information = inf;
    }

}
