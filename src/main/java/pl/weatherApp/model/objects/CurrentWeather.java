package pl.weatherApp.model.objects;

import javafx.beans.property.*;

public class CurrentWeather {
    public CurrentWeather() {}
    public CurrentWeather(String countryCode, String description, Integer temp, Integer feelsLikeTemp,Long humidity, Long pressure, Long visibility, Long clouds, String iconURL){
        this.countryCode.set(countryCode);
        this.description.set(description);
        this.temp.set(temp);
        this.feels_like.set(feelsLikeTemp);
        this.humidity.set(humidity);
        this.pressure.set(pressure);
        this.visibility.set(visibility);
        this.clouds.set(clouds);
        this.iconURL.set(iconURL);
    }

    private final IntegerProperty temp = new SimpleIntegerProperty();
    private final LongProperty humidity = new SimpleLongProperty();
    private final LongProperty pressure= new SimpleLongProperty(); //hPa
    private final IntegerProperty feels_like= new SimpleIntegerProperty();
    private final LongProperty visibility= new SimpleLongProperty(); //km
    private final StringProperty description= new SimpleStringProperty();
    private final LongProperty clouds= new SimpleLongProperty(); //%
    private final StringProperty iconURL = new SimpleStringProperty();
    private final StringProperty countryCode = new SimpleStringProperty();

    public String getCountryCode() {
        return countryCode.get();
    }
    public int getFeels_like() {
        return feels_like.get();
    }
    public int getTemp() {
        return temp.get();
    }
    public long getHumidity() {
        return humidity.get();
    }
    public long getPressure() {
        return pressure.get();
    }
    public long getVisibility() {
        return visibility.get();
    }
    public String getDescription() {
        return description.get();
    }
    public long getClouds() {
        return clouds.get();
    }
    public String getIconURL() {
        return iconURL.get();
    }
}
