package com.pagisoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, ApiException, IOException {
        //System.out.println( "Hello World!" );

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("***")
                .build();

        PlacesSearchResponse results = PlacesApi.textSearchQuery(
                context,
                "zajęcia z ceramiki dla dzieci opole"
        ).await();

        PlaceDetails details = PlacesApi.placeDetails(
                context,
                "ChIJJwG6cJlTEEcR8SobR_8pC4g"
        ).await();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(details));

    }
}
