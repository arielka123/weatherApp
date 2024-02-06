package pl.weatherApp.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import pl.weatherApp.model.objects.collections.Units;
import pl.weatherApp.model.service.CurrentWeatherService;
import pl.weatherApp.model.service.IService;
import pl.weatherApp.model.service.WeatherServiceManager;
import pl.weatherApp.model.objects.CurrentWeather;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.Validation;

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
    private final WeatherServiceManager weatherServiceManager;

    public CurrentWeatherView(WeatherServiceManager weatherServiceManager, TextField textField, Text desc, Text temp, Text feelsLike, Text pressure, Text visibility, Text clouds, Text humidity, Label countryCode, ImageView imageView) {
        this.weatherServiceManager = weatherServiceManager;
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
        Validation validation = new Validation();
        if (validation.textValidation(textField.getText())) {
            String txt = textField.getText();

            IService currentWeatherService = new CurrentWeatherService();
            CurrentWeather currentWeather = (CurrentWeather) weatherServiceManager.createWeather(txt,currentWeatherService);

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
        }else DialogUtils.inputDialog();

    }
    private void setImage(CurrentWeather currentWeather, ImageView imageView) {
        String imageSource = currentWeather.getIconURL();
        Image image = new Image(imageSource);
        imageView.setImage(image);
    }
}
