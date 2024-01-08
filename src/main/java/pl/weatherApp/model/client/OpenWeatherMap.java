package pl.weatherApp.model.client;

import pl.weatherApp.Config;
import pl.weatherApp.model.service.objects.Location;

public class OpenWeatherMap {

    public static String getCurrentWeatherURL(Location location){
        return "https://api.openweathermap.org/data/2.5/weather?q=" + location.getCity() + "&appid=" + Config.WEATHER_API+"&lang="+Config.language +"&units=metric";
    }

    public static String getGeolocationURL(String city){
        return "https://api.openweathermap.org/geo/1.0/direct?q="+city+"&limit=1&appid="+Config.WEATHER_API;
    }
}
