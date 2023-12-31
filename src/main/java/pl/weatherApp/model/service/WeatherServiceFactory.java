package pl.weatherApp.model.service;

public class WeatherServiceFactory {
//    public static WeatherService createWeatherService(){
//        return new WeatherService(createWeatherClient());
//    }

    public static void createWeatherClient(){
        createCurrentWeather();
        createForecastFiveDays();
    }

    public static CurrentWeatherService createCurrentWeather(){
        return new CurrentWeatherService();
    }

    public static ForecastWeatherService createForecastFiveDays(){
        return new ForecastWeatherService();
    }
}
