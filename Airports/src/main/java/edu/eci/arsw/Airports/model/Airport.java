package edu.eci.arsw.Airports.model;

import java.util.ArrayList;

public class Airport {

    private String airportId;
    private String code;
    private String name;
    private Location location;
    private String cityId;
    private String city;
    private String countryCode;
    private ArrayList<String> themes;
    private ArrayList<String> pointsOfSale;

    public Airport(String airportId, String code, String name, String cityId, String city, String countryCode){
        this.airportId = airportId;
        this.code = code;
        this.name = name;
        this.location = null;
        this.cityId = cityId;
        this.city = city;
        this.countryCode = countryCode;
        this.themes = null;
        this.pointsOfSale = null;
    }

    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public ArrayList<String> getThemes() {
        return themes;
    }

    public void setThemes(ArrayList<String> themes) {
        this.themes = themes;
    }

    public ArrayList<String> getPointsOfSale() {
        return pointsOfSale;
    }

    public void setPointsOfSale(ArrayList<String> pointsOfSale) {
        this.pointsOfSale = pointsOfSale;
    }
    
}