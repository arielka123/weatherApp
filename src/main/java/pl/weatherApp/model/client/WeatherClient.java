package pl.weatherApp.model.client;

public class WeatherClient extends WeatherServiceFactory {

    public static String getCurrentWeatherURL(){
        return OpenWeather.currentWeatherURL;
    }
}
