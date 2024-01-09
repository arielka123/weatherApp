package pl.weatherApp.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import pl.weatherApp.model.Units;
import pl.weatherApp.model.service.objects.CurrentWeather;
import pl.weatherApp.model.service.WeatherServiceFactory;
import pl.weatherApp.model.utils.TextValidation;

public class CurrentWeatherView {
    private final TextField textField;
    private final Text humidity;
    private final Text clouds;
    private final Text desc;
    private final Text temp;
    private final Text feelsLike;
    private final Text pressure;
    private final Text visibility;
    private final ImageView imageView;
    private final Label countryCode;
    private final WeatherServiceFactory weatherServiceFactory;

    public CurrentWeatherView(WeatherServiceFactory weatherServiceFactory, TextField textField, Text desc, Text temp,Text feelsLike, Text pressure,Text visibility,Text clouds,Text humidity,Label countryCode,ImageView imageView) {
        this.weatherServiceFactory = weatherServiceFactory;
        this.textField = textField;
        this.humidity = humidity;
        this.clouds = clouds;
        this.desc = desc;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.visibility = visibility;
        this.imageView = imageView;
        this.countryCode = countryCode;
    }

    public void create() {
        if (TextValidation.inputValidation(textField)) {
            CurrentWeather currentWeather = weatherServiceFactory.createCurrentWeather(textField.getText());
            desc.setText(currentWeather.getDescription());
            countryCode.setText(currentWeather.getCountryCode());
            temp.setText(currentWeather.getTemp() + Units.temperature);
            feelsLike.setText(currentWeather.getFeels_like() + Units.temperature);
            pressure.setText(currentWeather.getPressure() + Units.pressure);
            visibility.setText(currentWeather.getVisibility() + Units.visibility);
            clouds.setText(currentWeather.getClouds() + Units.cloud);
            humidity.setText(currentWeather.getHumidity() + Units.humidity);
            setImage(currentWeather, imageView);
            countryCode.setTextFill(Color.GRAY);
        }
    }
    private void setImage(CurrentWeather currentWeather, ImageView imageView) {
        String imageSource = currentWeather.getIconURL();
        Image image = new Image(imageSource);
        imageView.setImage(image);
    }
}
