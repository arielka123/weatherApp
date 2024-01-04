package pl.weatherApp.model.client;

import pl.weatherApp.Config;
import pl.weatherApp.model.service.LocalizationService;

public class OpenWeatherMap {

    public static String getCurrentWeatherURL(LocalizationService localizationService){
        return "https://api.openweathermap.org/data/2.5/weather?q=" + localizationService.getCity() + "&appid=" + Config.WEATHER_API+"&lang="+Config.language +"&units=metric";
    }

    public static String getGeolocationURL(LocalizationService localizationService){
        return "https://api.openweathermap.org/geo/1.0/direct?q="+localizationService.getCity()+"&limit=1&appid="+Config.WEATHER_API;
    }
//    private static String loadCity(){
////        Localization localization = new Localization();
////        return LocalizationService.getCity();
//    }

}
