package pl.weatherApp.model.client;

import pl.weatherApp.Config;

public class CurrentWeather implements Weather {

    public static String getURL(){
        String currenrtURL = null;
        currenrtURL = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + Config.WEATHER_API+"&lang=pl&units=metric";
        return currenrtURL;
    }
}
