package pl.weatherApp.model.service;

import static pl.weatherApp.model.service.CurrentWeatherService.init;

public class WeatherServiceFactory {

    public static void createWeatherService(){
        createLocalization();
        createCurrentWeather();
        createForecastFiveDays();
    }

    public static void createLocalization(){
        LocalizationService localizationService = new LocalizationService();
        localizationService.init();
    }
    public static CurrentWeather createCurrentWeather(){
        createLocalization();
        return init();
    }

    public static ForecastWeatherService createForecastFiveDays(){
        return new ForecastWeatherService();
    }
}
