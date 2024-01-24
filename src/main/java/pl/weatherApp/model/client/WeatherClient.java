package pl.weatherApp.model.client;

import pl.weatherApp.model.service.objects.Location;

import java.net.MalformedURLException;
import java.net.URL;

public class WeatherClient {

    public static URL getLocationURL(String city) {
        try {
            return new URL(OpenWeatherMap.getGeolocationURL(city));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static URL getCurrentWeatherURL(Location location){
        try {
            return new URL(OpenWeatherMap.getCurrentWeatherURL(location));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static URL getForecastURL(Location location) {
        try {
            return new URL(OpenMeteo.getForecastURL(location));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
