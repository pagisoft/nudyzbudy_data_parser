package com.pagisoft;

public class GoogleMapsQueryBuilder {

    private String category;
    private String city;
    private String queryBody;
    private String nextPageToken;

    public GoogleMapsQueryBuilder(String category, String city, String queryBody) {
        this.category = category;
        this.city = city;
        this.queryBody = queryBody;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQueryBody() {
        return queryBody;
    }

    public void setQueryBody(String queryBody) {
        this.queryBody = queryBody;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }


}
