package pl.weatherApp.model.client;

import pl.weatherApp.Config;

public class OpenWeather {
    public static String cityName = "Warszawa";
    public static String currentWeatherURL ="https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + Config.WEATHER_API+"&lang=pl&units=metric";
}
