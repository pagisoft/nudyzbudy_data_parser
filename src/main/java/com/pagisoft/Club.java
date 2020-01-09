package com.pagisoft;

public class Club {
    private String address;
    private String email;
    private String name;
    private String phone;
    private String city;
    private String category;
    private String placeId;
    private String website;
    private String politicalArea;

    public Club() {}

    public Club(String name, String address, String email, String latitude, String longitude, String phone, String city, String category) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return "Brak adresu e-mail";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPoliticalArea() {
        return politicalArea;
    }

    public void setPoliticalArea(String politicalArea) {
        this.politicalArea = politicalArea;
    }



}
