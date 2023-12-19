package pl.weatherApp.model.client;

public class WeatherServiceFactory {
//    public static WeatherService createWeatherService(){
//        return new WeatherService(createWeatherClient());
//    }

    public static CurrentWeather createWeatherClient(){
        return new CurrentWeather();
    }
}
