package pl.weatherApp.model;

import pl.weatherApp.model.service.ForecastWeather;

import java.util.ArrayList;

public class WeatherCollection {
    private final ArrayList<ForecastWeather> ForecastList = new ArrayList<>();
    public ForecastWeather getForecastList(int i){
        return ForecastList.get(i);
    }
    public void addObjectToForecastList(ForecastWeather forecastWeather){
        ForecastList.add(forecastWeather);
    }
}
