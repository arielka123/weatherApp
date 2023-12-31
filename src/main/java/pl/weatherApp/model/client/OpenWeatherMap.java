package pl.weatherApp.model.client;

import pl.weatherApp.Config;
import pl.weatherApp.model.service.Localization;

public class OpenWeatherMap {
    public static String currentWeatherURL ="https://api.openweathermap.org/data/2.5/weather?q=" + loadCity() + "&appid=" + Config.WEATHER_API+"&lang="+Config.language +"&units=metric";

    public static String geolocationURL = "https://api.openweathermap.org/geo/1.0/direct?q="+loadCity()+"&limit=1&appid="+Config.WEATHER_API;

    private static String loadCity(){
        Localization localization = new Localization();
        return localization.getCity();
    }
}
