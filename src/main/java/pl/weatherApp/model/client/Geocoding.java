package pl.weatherApp.model.client;

public class Geocoding {
    public static String geocodingURL = "https://geocoding-api.open-meteo.com/v1/search?name="+setCity()+"&language="+getLanguage()+"&format=json&count=1";

    public static String setCity(){
        return "Warszawa";
    }

    public static String getLanguage(){
        return "pl";
    }

    //TODO user set language
}
