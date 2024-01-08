package pl.weatherApp.model.client;

import pl.weatherApp.model.service.objects.Location;

public class WeatherClient {

    public static String getCurrentWeatherURL(Location location){
        return OpenWeatherMap.getCurrentWeatherURL(location);
    }
    public static String getLocationURL(String city){
        return OpenWeatherMap.getGeolocationURL(city);
    }

    public static String getForecastURL(Location location){
        return OpenMeteo.getForecastURL(location);
    }
}
