package pl.weatherApp.model.client;

import javafx.beans.property.*;

public class Weather {
    private DoubleProperty temp = new SimpleDoubleProperty();
    private LongProperty humidity = new SimpleLongProperty();
    private LongProperty pressure= new SimpleLongProperty(); //hPa
    private DoubleProperty feels_like= new SimpleDoubleProperty();
    private LongProperty visibility= new SimpleLongProperty(); //km
    private StringProperty description= new SimpleStringProperty();
    private LongProperty clouds= new SimpleLongProperty(); //%

//    public static Double temp = null;  //oC
//    public static Long humidity = null;   //%
//    public static Long pressure= null; //hPa
//    public static Double feels_like= null;
//    public static Long visibility= null; //km
//    public static String description= null;
//    public static Long clouds= null; //%


    public double getTemp() {
        return temp.get();
    }

    public DoubleProperty tempProperty() {
        return temp;
    }

    public void setTemp(double temp) {
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

    public DoubleProperty feels_likeProperty() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like.set(feels_like);
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
