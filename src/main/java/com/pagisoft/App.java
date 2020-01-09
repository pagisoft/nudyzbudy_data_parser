package com.pagisoft;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{

    static List<String> cities = new ArrayList<String>(List.of(
            "Głubczyce",
            "Kędzierzyn-Koźle",
            "Kluczbork",
            "Krapkowice",
            "Namysłów",
            "Nysa",
            "Olesno",
            //"Opole",
            "Prudnik",
            "Strzelce Opolskie"
            ));

/*
    static Map<String, String> categories = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, String>("Aqua fitness", "aqua fitness dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Biologia", "zajęcia z biologii dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Boks", "kluby bokserskie dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Breakdance", "breakdance dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Ceramika", "zajęcia z ceramiki dla dzieci"),
            new AbstractMap.SimpleEntry<String, String>("Crossfit", "crossfit dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Fotografia", "zajęcia z fotografii dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Gimnastyka artystyczna", "gimnastyka artystyczna dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Instrumenty muzyczne", "zajęcia z gry na instrumentach muzycznych dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Jeździectwo", "jeździectwo dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Język angielski", "zajęcia z języka angielskiego dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Język francuski", "zajęcia z języka francuskiego dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Język hiszpański", "zajęcia z języka hiszpańskiego dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Język niemiecki", "zajęcia z języka niemieckiego dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Judo", "judo dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Karate", "karate dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Malarstwo", "zajęcia z malarstwa dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Matematyka", "zajęcia z matematyki dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Modelarstwo", "zajęcia z modelarstwa dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Piłka nożna", "piłka nożna dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Piłka siatkowa", "siatkówka dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Plastyka", "zajęcia z plastyki dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Pływanie", "pływanie dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Robotyka", "zajęcia z robotyki dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Taniec towarzyski", "taniec towarzyski dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Tenis", "tenis dla dzieci i młodzieży")
    );*/

    static Map<String, String> categoriesSport = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, String>("Aqua fitness", "aqua fitness dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Boks", "kluby bokserskie dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Crossfit", "crossfit dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Gimnastyka artystyczna", "gimnastyka artystyczna dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Jeździectwo", "jeździectwo dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Judo", "judo dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Karate", "karate dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Piłka nożna", "piłka nożna dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Piłka siatkowa", "siatkówka dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Pływanie", "pływanie dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Tenis", "tenis dla dzieci i młodzieży")
    );

    static Map<String, String> categoriesEducation = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, String>("Biologia", "zajęcia z biologii dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Język angielski", "zajęcia z języka angielskiego dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Język francuski", "zajęcia z języka francuskiego dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Język hiszpański", "zajęcia z języka hiszpańskiego dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Język niemiecki", "zajęcia z języka niemieckiego dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Matematyka", "zajęcia z matematyki dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Robotyka", "zajęcia z robotyki dla dzieci i młodzieży")
    );

    static Map<String, String> categoriesDance = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, String>("Breakdance", "breakdance dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Taniec towarzyski", "taniec towarzyski dla dzieci i młodzieży")
    );

    static Map<String, String> categoriesArtistic = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, String>("Ceramika", "zajęcia z ceramiki dla dzieci"),
            new AbstractMap.SimpleEntry<String, String>("Fotografia", "zajęcia z fotografii dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Instrumenty muzyczne", "zajęcia z gry na instrumentach muzycznych dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Malarstwo", "zajęcia z malarstwa dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Modelarstwo", "zajęcia z modelarstwa dla dzieci i młodzieży"),
            new AbstractMap.SimpleEntry<String, String>("Plastyka", "zajęcia z plastyki dla dzieci i młodzieży")
    );

    public static void main( String[] args ) throws InterruptedException, ApiException, IOException {

        XMLGenerator generator = new XMLGenerator();

        for (String city : cities) {
            List<Club> clubsCollectionSport = new ArrayList<Club>();
            List<Club> clubsCollectionEducation = new ArrayList<Club>();
            List<Club> clubsCollectionDance = new ArrayList<Club>();
            List<Club> clubsCollectionArtistic = new ArrayList<Club>();

            System.out.println("-----------------------------------");
            System.out.println(city);
            System.out.println("-----------------------------------");

            clubsCollectionSport.addAll(processCategories(city, categoriesSport));
            clubsCollectionEducation.addAll(processCategories(city, categoriesEducation));
            clubsCollectionDance.addAll(processCategories(city, categoriesDance));
            clubsCollectionArtistic.addAll(processCategories(city, categoriesArtistic));

            if (clubsCollectionSport.size() > 0) {
                generator.generateXMLFile(clubsCollectionSport, "xml_to_upload//" + city.toLowerCase() + "_sport.xml");
            }

            if (clubsCollectionEducation.size() > 0) {
                generator.generateXMLFile(clubsCollectionEducation, "xml_to_upload//" + city.toLowerCase() + "_edukacja.xml");
            }

            if (clubsCollectionDance.size() > 0) {
                generator.generateXMLFile(clubsCollectionDance, "xml_to_upload//" + city.toLowerCase() + "_taniec.xml");
            }

            if (clubsCollectionArtistic.size() > 0) {
                generator.generateXMLFile(clubsCollectionArtistic, "xml_to_upload//" + city.toLowerCase() + "_zajecia_artystyczne.xml");
            }

        }

        System.exit(0);

    }

    private static List<Club> processCategories(String city, Map<String, String> categories) throws InterruptedException, ApiException, IOException {

        List<Club> clubsCollectionAll = new ArrayList<Club>();
        Integer count = 0;
        for (String category : categories.keySet()) {
            System.out.println(category);
            GoogleMapsQueryBuilder queryBuilder = new GoogleMapsQueryBuilder(
                    category,
                    city,
                    categories.get(category) + " " + city.toLowerCase());

            List<Club> clubsCollection = new GoogleMapsReader().getClubListByQuery(queryBuilder);
            System.out.println(city + " : " + category + " : " + clubsCollection.size());

            if (clubsCollection.size() > 0) {
                clubsCollectionAll.addAll(clubsCollection);
            }

            count+= clubsCollection.size();
        }

        clubsCollectionAll = deduplicateCollectionByPlaceId(clubsCollectionAll);

        System.out.println(city + " : Counted single type count: " + count);
        System.out.println(city + " : Real single type count: " + clubsCollectionAll.size());

        return clubsCollectionAll;
    }

    private static List<Club> deduplicateCollectionByPlaceId(List<Club> clubsCollection) {

        List<Club> deduplicatedClubsCollection = new ArrayList<Club>();

        for (int i = 0; i < clubsCollection.size(); i++) {

            Club currentClub = clubsCollection.get(i);

            Boolean checkIfExisis = deduplicatedClubsCollection.stream().filter(
                    o -> o.getPlaceId().equals(currentClub.getPlaceId())
            ).findFirst().isPresent();

            if (!checkIfExisis) {
                deduplicatedClubsCollection.add(currentClub);
            }
        }
        return deduplicatedClubsCollection;

    }
}
