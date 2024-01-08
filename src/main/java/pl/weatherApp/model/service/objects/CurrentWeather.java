package pl.weatherApp.model.service.objects;

import javafx.beans.property.*;

public class CurrentWeather {
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
    public void setCountryCode(String countryCode) {
        this.countryCode.set(countryCode);
    }
    public void setFeels_like(int feels_like) {
        this.feels_like.set(feels_like);
    }
    public int getFeels_like() {
        return feels_like.get();
    }
    public int getTemp() {
        return temp.get();
    }
    public void setTemp(int temp) {
        this.temp.set(temp);
    }
    public long getHumidity() {
        return humidity.get();
    }
    public void setHumidity(long humidity) {
        this.humidity.set(humidity);
    }
    public long getPressure() {
        return pressure.get();
    }
    public void setPressure(long pressure) {
        this.pressure.set(pressure);
    }
    public long getVisibility() {
        return visibility.get();
    }
    public void setVisibility(long visibility) {
        this.visibility.set(visibility);
    }
    public String getDescription() {
        return description.get();
    }
    public void setDescription(String description) {
        this.description.set(description);
    }
    public long getClouds() {
        return clouds.get();
    }
    public void setClouds(long clouds) {
        this.clouds.set(clouds);
    }
    public String getIconURL() {
        return iconURL.get();
    }
    public void setIconURL(String iconURL) {
        this.iconURL.set(iconURL);
    }
}
