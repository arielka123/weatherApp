package pl.weatherApp.model.objects;

import javafx.beans.property.*;

public class ForecastWeather {
    public ForecastWeather() {
    }

    public ForecastWeather(String countryCode, String weatherCode, String date, String dayOfWeek, Integer tempMax, Integer tempMin, Integer feels_likeMin, Integer feels_likeMax, Double precipitation, Double windSpeed, Integer windDirection) {
        this.countryCode.set(countryCode);
        this.weather_code = weatherCode;
        this.dateStr.set(date);
        this.dayOfWeek.set(dayOfWeek);
        this.tempMax.set(tempMax);
        this.tempMin.set(tempMin);
        this.tempMax.set(tempMax);
        this.feels_likeMin.set(feels_likeMin);
        this.feels_likeMax.set(feels_likeMax);
        this.precipitation.set(precipitation);
        this.windDirection = windDirection;
        this.windSpeed.set(windSpeed);
    }

    private final StringProperty dateStr = new SimpleStringProperty();
    private final StringProperty dayOfWeek = new SimpleStringProperty();
    private final IntegerProperty tempMax = new SimpleIntegerProperty();
    private final IntegerProperty tempMin = new SimpleIntegerProperty();
    private final IntegerProperty feels_likeMax = new SimpleIntegerProperty();
    private final IntegerProperty feels_likeMin = new SimpleIntegerProperty();
    private final DoubleProperty precipitation = new SimpleDoubleProperty();
    private final StringProperty countryCode = new SimpleStringProperty();
    private String weather_code;
    private final DoubleProperty windSpeed = new SimpleDoubleProperty();
    private Integer windDirection;

    public String getCountryCode() {
        return countryCode.get();
    }

    public int getFeels_likeMin() {
        return feels_likeMin.get();
    }

    public double getPrecipitation() {
        return precipitation.get();
    }

    public String getDateStr() {
        return dateStr.get();
    }

    public int getTempMax() {
        return tempMax.get();
    }

    public Integer getTempMin() {
        return tempMin.get();
    }

    public int getFeels_likeMax() {
        return feels_likeMax.get();
    }

    public String getWeather_code() {
        return weather_code;
    }

    public double getWindSpeed() {
        return windSpeed.get();
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public String getDayOfWeek() {
        return dayOfWeek.get();
    }
}
