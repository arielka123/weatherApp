package pl.weatherApp.model.service;

import pl.weatherApp.model.collections.WeatherCollection;
import pl.weatherApp.model.service.objects.CurrentWeather;
import pl.weatherApp.model.service.objects.Location;

public class WeatherServiceManager {

    private static WeatherServiceManager instance;
    private WeatherServiceManager(){
        instance = this;
    }

    public static WeatherServiceManager init() {
        if (instance == null) {
            instance = new WeatherServiceManager();
        }
        return instance;
    }

    private Location createLocalization(String city){
        LocationService localizationService= new LocationService(city);
        return localizationService.init();
    }
    public CurrentWeather createCurrentWeather(String city){
        CurrentWeatherService currentWeatherService = new CurrentWeatherService();
        Location location = createLocalization(city);
        return currentWeatherService.init(location);
    }

    public WeatherCollection createForecast(String city){
        ForecastWeatherService forecastWeatherService = new ForecastWeatherService();
        Location location = createLocalization(city);
        return forecastWeatherService.init(location);
    }
}
