package pl.weatherApp.model.client;

import pl.weatherApp.model.service.LocationService;
import pl.weatherApp.model.service.WeatherServiceFactory;

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
