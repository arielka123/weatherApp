package pl.weatherApp.model.service;

import pl.weatherApp.model.client.OpenMeteo;
import pl.weatherApp.model.client.OpenWeatherMap;

public class WeatherClient extends WeatherServiceFactory {

    public static String getCurrentWeatherURL(){
        return OpenWeatherMap.currentWeatherURL;
    }
    public static String getLocalizationURL(){
        return OpenWeatherMap.geolocationURL;
    }

    public static String getForecastURL(){
        return OpenMeteo.forecastURL;
    }
}
