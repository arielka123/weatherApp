package pl.weatherApp.model.service;

import pl.weatherApp.model.client.OpenMeteo;
import pl.weatherApp.model.client.OpenWeatherMap;

public class WeatherClient extends WeatherServiceFactory {

    public static String getCurrentWeatherURL(LocalizationService localizationService){
        return OpenWeatherMap.getCurrentWeatherURL(localizationService);
    }
    public static String getLocalizationURL(LocalizationService localizationService){
        return OpenWeatherMap.getGeolocationURL(localizationService);
    }

    public static String getForecastURL(LocalizationService localizationService){
        return OpenMeteo.getForecastURL(localizationService);
    }
}
