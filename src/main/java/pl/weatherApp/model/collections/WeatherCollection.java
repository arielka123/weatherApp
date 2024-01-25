package pl.weatherApp.model.collections;

import pl.weatherApp.model.service.objects.ForecastWeather;

import java.util.ArrayList;

public class WeatherCollection {
    private final ArrayList<ForecastWeather> ForecastList = new ArrayList<>();
    public ForecastWeather getOneOfForecastList(int i){
        return ForecastList.get(i);
    }

    public ArrayList<ForecastWeather> getForecastList() {
        return ForecastList;
    }

    public void addObjectToForecastList(ForecastWeather forecastWeather){
        ForecastList.add(forecastWeather);


    }
}
