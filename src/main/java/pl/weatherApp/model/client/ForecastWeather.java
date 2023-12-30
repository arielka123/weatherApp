package pl.weatherApp.model.client;

import javafx.beans.property.*;

public class ForecastWeather {

    private final IntegerProperty tempMax = new SimpleIntegerProperty();
    private final IntegerProperty tempMin = new SimpleIntegerProperty();
    private final IntegerProperty feels_likeMax= new SimpleIntegerProperty();
    private final IntegerProperty feels_likeMin= new SimpleIntegerProperty();
    private  String weather_code;
    private final StringProperty windSpeed = new SimpleStringProperty();
    private Integer windDirection;

    public int getTempMax() {
        return tempMax.get();
    }

    public IntegerProperty tempMaxProperty() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax.set(tempMax);
    }

    public int getTempMin() {
        return tempMin.get();
    }

    public IntegerProperty tempMinProperty() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin.set(tempMin);
    }

    public int getFeels_likeMax() {
        return feels_likeMax.get();
    }

    public IntegerProperty feels_likeMaxProperty() {
        return feels_likeMax;
    }

    public void setFeels_likeMax(int feels_likeMax) {
        this.feels_likeMax.set(feels_likeMax);
    }

    public int getFeels_likeMin() {
        return feels_likeMin.get();
    }

    public IntegerProperty feels_likeMinProperty() {
        return feels_likeMin;
    }

    public void setFeels_likeMin(int feels_likeMin) {
        this.feels_likeMin.set(feels_likeMin);
    }

    public String getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(String weather_code) {
        this.weather_code = weather_code;
    }

    public String getWindSpeed() {
        return windSpeed.get();
    }

    public StringProperty windSpeedProperty() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed.set(windSpeed);
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }
}
