package pl.weatherApp.model.service;

import javafx.beans.property.*;

public class CurrentWeather {

    private final IntegerProperty temp = new SimpleIntegerProperty();
    private final LongProperty humidity = new SimpleLongProperty();
    private final LongProperty pressure= new SimpleLongProperty(); //hPa
    private final IntegerProperty feels_like= new SimpleIntegerProperty();
    private final LongProperty visibility= new SimpleLongProperty(); //km
    private final StringProperty description= new SimpleStringProperty();
    private final LongProperty clouds= new SimpleLongProperty(); //%

    public void setFeels_like(int feels_like) {
        this.feels_like.set(feels_like);
    }

    public int getTemp() {
        return temp.get();
    }

    public IntegerProperty tempProperty() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp.set(temp);
    }

    public long getHumidity() {
        return humidity.get();
    }

    public LongProperty humidityProperty() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity.set(humidity);
    }

    public long getPressure() {
        return pressure.get();
    }

    public LongProperty pressureProperty() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure.set(pressure);
    }

    public double getFeels_like() {
        return feels_like.get();
    }

    public long getVisibility() {
        return visibility.get();
    }

    public LongProperty visibilityProperty() {
        return visibility;
    }

    public void setVisibility(long visibility) {
        this.visibility.set(visibility);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public long getClouds() {
        return clouds.get();
    }

    public LongProperty cloudsProperty() {
        return clouds;
    }

    public void setClouds(long clouds) {
        this.clouds.set(clouds);
    }
}
