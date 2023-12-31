package pl.weatherApp.model.service;

import java.util.ArrayList;

public class WeatherCollection {
    static private final ArrayList<ForecastWeather> ForecastList = new ArrayList<>();
    static private final ArrayList<Units> WeatherUnits = new ArrayList<>();

    public static Units getWeatherUnits(int i){
        return WeatherUnits.get(i);
    }

    public static ForecastWeather getForecastList(int i){
        return ForecastList.get(i);
    }

    public static void addObjectToForecastList(ForecastWeather forecastWeather){
        ForecastList.add(forecastWeather);
    }

    public static void addObjectToUnitsList(Units units){
        WeatherUnits.add(units);
    }
    ///System.out.println(WeatherCollection.getForecastList(0).getTime());
}
