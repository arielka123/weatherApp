package pl.weatherApp.model.service;

public class WeatherServiceFactory {

    public LocalizationService createLocalization(String city){
        LocalizationService localizationService= new LocalizationService(city);
        localizationService.init();
        return localizationService;
    }
    public CurrentWeather createCurrentWeather(String city){
        CurrentWeatherService currentWeatherService = new CurrentWeatherService();
        return currentWeatherService.init(createLocalization(city));
    }

    public ForecastWeatherService createForecastFiveDays(String city){
        return new ForecastWeatherService(createLocalization(city));
    }
}
