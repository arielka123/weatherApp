package pl.weatherApp.model.client;

public class WeatherServiceFactory {
//    public static WeatherService createWeatherService(){
//        return new WeatherService(createWeatherClient());
//    }

    public static void createWeatherClient(){
        createCurrentWeather();
    }

    public static CurrentWeather createCurrentWeather(){
        return new CurrentWeather();
    }
}
