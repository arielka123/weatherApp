package pl.weatherApp.model.client;

import pl.weatherApp.Config;
import pl.weatherApp.model.service.LocationService;

public class OpenWeatherMap {

    public static String getCurrentWeatherURL(LocationService locationService){
        return "https://api.openweathermap.org/data/2.5/weather?q=" + locationService.getCity() + "&appid=" + Config.WEATHER_API+"&lang="+Config.language +"&units=metric";
    }

    public static String getGeolocationURL(String city){
        return "https://api.openweathermap.org/geo/1.0/direct?q="+city+"&limit=1&appid="+Config.WEATHER_API;
    }
//    private static String loadCity(){
////        Localization localization = new Localization();
////        return LocalizationService.getCity();
//    }

}
