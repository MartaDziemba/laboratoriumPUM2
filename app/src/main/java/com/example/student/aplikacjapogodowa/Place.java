package com.example.student.aplikacjapogodowa;

/**
 * Created by Marta on 28.12.2017.
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

    public Place(String placeName, int temperature)
    {
        this.placeName=placeName;
        this.temperature=temperature;
    }
    public Place(String placeName, int temperature, String information)
    {
        this.placeName=placeName;
        this.temperature=temperature;
        this.information=information;
    }

    public Place(String placeName, String information) {
        this.placeName = placeName;
        this.information = information;
    }
}
