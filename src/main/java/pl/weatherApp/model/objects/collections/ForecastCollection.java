package pl.weatherApp.model.objects.collections;

import pl.weatherApp.model.objects.ForecastWeather;

import java.util.ArrayList;

public class ForecastCollection {
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
