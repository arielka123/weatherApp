package pl.weatherApp.model.service;

import static pl.weatherApp.model.service.CurrentWeatherService.init;

public class WeatherServiceFactory {

    public LocalizationService createLocalization(String city){
        LocalizationService localizationService;
        localizationService = new LocalizationService(city);
        localizationService.init();
        return localizationService;
    }
    public CurrentWeather createCurrentWeather(String city){
        return init(createLocalization(city));
    }

    public ForecastWeatherService createForecastFiveDays(String city){
        return new ForecastWeatherService(createLocalization(city));
    }
}
