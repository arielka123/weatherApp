package pl.weatherApp.model.service.objects;

import javafx.beans.property.*;

public class ForecastWeather {
    private  final StringProperty dateStr = new SimpleStringProperty();
    private final StringProperty dayOfWeek = new SimpleStringProperty();
    private final IntegerProperty tempMax = new SimpleIntegerProperty();
    private final IntegerProperty tempMin = new SimpleIntegerProperty();
    private final IntegerProperty feels_likeMax= new SimpleIntegerProperty();
    private final IntegerProperty feels_likeMin= new SimpleIntegerProperty();
    private final DoubleProperty precipitation = new SimpleDoubleProperty();
    private final StringProperty countryCode = new SimpleStringProperty();
    private  String weather_code;
    private final DoubleProperty windSpeed = new SimpleDoubleProperty();
    private Integer windDirection;

    public String getCountryCode() {
        return countryCode.get();
    }
    public void setCountryCode(String countryCode) {
        this.countryCode.set(countryCode);
    }
    public int getFeels_likeMin() {
        return feels_likeMin.get();
    }
    public void setFeels_likeMin(int feels_likeMin) {
        this.feels_likeMin.set(feels_likeMin);
    }
    public double getPrecipitation() {
        return precipitation.get();
    }
    public void setPrecipitation(double precipitation) {
        this.precipitation.set(precipitation);
    }
    public String getDateStr() {
        return dateStr.get();
    }
    public void setDateStr(String dateStr) {
        this.dateStr.set(dateStr);
    }
//    public int getTempMax() {
//        return tempMax.get();
//    }
    public void setTempMax(int tempMax) {
        this.tempMax.set(tempMax);
    }
    public Integer getTempMin() {
        return tempMin.get();
    }
    public void setTempMin(int tempMin) {
        this.tempMin.set(tempMin);
    }
//    public int getFeels_likeMax() {
//        return feels_likeMax.get();
//    }
    public void setFeels_likeMax(int feels_likeMax) {
        this.feels_likeMax.set(feels_likeMax);
    }
    public String getWeather_code() {
        return weather_code;
    }
    public void setWeather_code(String weather_code) {
        this.weather_code = weather_code;
    }
    public double getWindSpeed() {
        return windSpeed.get();
    }
    public void setWindSpeed(double windSpeed) {
        this.windSpeed.set(windSpeed);
    }
    public Integer getWindDirection() {
        return windDirection;
    }
    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }

    public String getDayOfWeek() {
        return dayOfWeek.get();
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek.set(dayOfWeek);
    }
}
