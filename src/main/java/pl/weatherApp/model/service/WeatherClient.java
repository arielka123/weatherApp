package pl.weatherApp.model.service;

import pl.weatherApp.model.client.OpenMeteo;
import pl.weatherApp.model.client.OpenWeatherMap;

public class WeatherClient extends WeatherServiceFactory {

    public static String getCurrentWeatherURL(LocationService locationService){
        return OpenWeatherMap.getCurrentWeatherURL(locationService);
    }
    public static String getLocationURL(String city){
        return OpenWeatherMap.getGeolocationURL(city);
    }

    public static String getForecastURL(LocationService locationService){
        return OpenMeteo.getForecastURL(locationService);
    }
}
