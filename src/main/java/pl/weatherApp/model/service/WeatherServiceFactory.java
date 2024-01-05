package pl.weatherApp.model.service;

public class WeatherServiceFactory {

    public LocationService createLocalization(String city){
        LocationService localizationService= new LocationService(city);
        localizationService.init();
        return localizationService;
    }
    public CurrentWeather createCurrentWeather(String city){
        CurrentWeatherService currentWeatherService = new CurrentWeatherService();
        return currentWeatherService.init(createLocalization(city));
    }

    public WeatherCollection createForecastFiveDays(String city){
        ForecastWeatherService forecastWeatherService = new ForecastWeatherService();
        return forecastWeatherService.init(createLocalization(city));
//        return new ForecastWeatherService(createLocalization(city));
    }
}
