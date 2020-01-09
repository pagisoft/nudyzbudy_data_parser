package com.pagisoft;

import com.google.gson.*;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GoogleMapsReader {

    private static final String API_KEY = "TEST";

    //private static final Logger LOGGER = LogManager.getLogger(GoogleMapsReader.class);

    public List<Club> getClubListByQuery(GoogleMapsQueryBuilder queryBuilder) throws InterruptedException, ApiException, IOException {

        List<Club> clubList = new ArrayList<Club>();

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();

        PlacesSearchResponse results;

        if (queryBuilder.getNextPageToken() == null || queryBuilder.getNextPageToken().isEmpty()) {
            results = PlacesApi.textSearchQuery(
                    context,
                    queryBuilder.getQueryBody()
            )
                    .language("pl")
                    .await();
        } else {
            results = PlacesApi.textSearchQuery(
                    context,
                    queryBuilder.getQueryBody()
            )
                    .language("pl")
                    .pageToken(queryBuilder.getNextPageToken())
                    .await();
        }

        //Thread.sleep(15 * 1000);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //System.out.println(gson.toJson(results));


        JsonObject jsonObject = new Gson().fromJson(gson.toJson(results), JsonObject.class);
        JsonArray resultsArray = jsonObject.get("results").getAsJsonArray();

        //if (results.nextPageToken != null) {
        //    System.out.println(results.nextPageToken);
        //} else {
        //    System.out.println("Brak tokena.");
        //}

        //System.exit(0);

        if (resultsArray == null || resultsArray.size() == 0) {
            System.out.println("Pusta kolekcja.");
            return clubList;
        }

        for (int i = 0; i < resultsArray.size(); i++) {
            JsonObject singleResult = resultsArray.get(i).getAsJsonObject();

            Club club = new Club();
            club.setName(singleResult.get("name").getAsString());
            club.setAddress(singleResult.get("formattedAddress").getAsString());
            club.setPlaceId(singleResult.get("placeId").getAsString());
            club.setCategory(queryBuilder.getCategory());
            club.setCity(queryBuilder.getCity());

            club = getPlaceDetails(context, club);


            if (club.getPhone() != null) {
                if (club.getCity().equals(club.getPoliticalArea())) {
                    clubList.add(club);
                }
            }
        }

        if (results.nextPageToken != null) {
            System.out.println(results.nextPageToken);
            queryBuilder.setNextPageToken(results.nextPageToken);
            clubList.addAll(getClubListByQuery(queryBuilder));
            //return getClubListByQuery(queryBuilder);
        } else {
            System.out.println("Brak tokena.");
        }

        return clubList;
    }

    private Club getPlaceDetails(GeoApiContext context, Club club) throws InterruptedException, ApiException, IOException {

        PlaceDetails details = PlacesApi.placeDetails(
                context,
                club.getPlaceId()
        ).await();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = new Gson().fromJson(gson.toJson(details), JsonObject.class);


        //System.out.println(gson.toJson(details));

        if (jsonObject.get("internationalPhoneNumber") != null) {
            club.setPhone(jsonObject.get("internationalPhoneNumber").toString().replace("\"", ""));
        }

        if (jsonObject.get("website") != null) {
            club.setWebsite(jsonObject.get("website").toString().replace("\"", ""));
        }

        JsonArray addressArray = jsonObject.get("addressComponents").getAsJsonArray();

        for (int i = 0; i < addressArray.size(); i++) {
            JsonObject singleResult = addressArray.get(i).getAsJsonObject();
            //ADMINISTRATIVE_AREA_LEVEL_2
            JsonArray singleResultTypes = singleResult.get("types").getAsJsonArray();
            for (int j = 0; j < singleResultTypes.size(); j++) {
                String singleType = singleResultTypes.get(j).getAsString();
                if (singleType.equals("LOCALITY")) {
                    System.out.println(singleResult.get("longName").getAsString());
                    club.setPoliticalArea(singleResult.get("longName").getAsString());
                    break;
                }
            }
        }


        return club;
    }

}
