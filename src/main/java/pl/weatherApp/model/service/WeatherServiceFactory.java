package pl.weatherApp.model.service;

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
    public static CurrentWeatherService createCurrentWeather(){
        return new CurrentWeatherService();
    }

    public static ForecastWeatherService createForecastFiveDays(){
        return new ForecastWeatherService();
    }
}
