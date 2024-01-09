package pl.weatherApp.model.service;

import pl.weatherApp.model.collections.WeatherCollection;
import pl.weatherApp.model.service.objects.CurrentWeather;
import pl.weatherApp.model.service.objects.Location;

public class WeatherServiceFactory {

    private static WeatherServiceFactory instance;
    private WeatherServiceFactory(){
        instance = this;
    }

    public static WeatherServiceFactory init() {
        if (instance == null) {
            instance = new WeatherServiceFactory();
        }
        return instance;
    }

    public Location createLocalization(String city){
        LocationService localizationService= new LocationService(city);
        return localizationService.init();
    }
    public CurrentWeather createCurrentWeather(String city){
        CurrentWeatherService currentWeatherService = new CurrentWeatherService();
        return currentWeatherService.init(createLocalization(city));
    }

    public WeatherCollection createForecastDays(String city){
        ForecastWeatherService forecastWeatherService = new ForecastWeatherService();
        return forecastWeatherService.init(createLocalization(city));
    }
}
