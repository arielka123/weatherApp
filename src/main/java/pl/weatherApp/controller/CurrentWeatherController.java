package pl.weatherApp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import pl.weatherApp.model.Units;
import pl.weatherApp.model.service.CurrentWeather;
import pl.weatherApp.model.service.WeatherServiceFactory;
import pl.weatherApp.model.utils.TextValidation;

public class CurrentWeatherController {
    @FXML
    private Button buttonCity2;
    @FXML
    private Button buttonCity1;

    @FXML
    private TextField textFieldCity1;
    @FXML
    private TextField textFieldCity2;
    @FXML
    private Text cloudsCity2;
    @FXML
    private Text descCity2;
    @FXML
    private Text humidityCity2;
    @FXML
    private Text visibilityCity2;
    @FXML
    private Text pressureCity2;
    @FXML
    private Text feelsLikeCity2;
    @FXML
    private Text tempCity2;
    @FXML
    private Text humidityCity1;
    @FXML
    private Text cloudsCity1;
    @FXML
    private Text descCity1;
    @FXML
    private Text tempCity1;
    @FXML
    private Text feelsLikeCity1;
    @FXML
    private Text pressureCity1;
    @FXML
    private Text visibilityCity1;
    @FXML
    private ImageView imageViewCity1;
    @FXML
    private ImageView imageViewCity2;
    @FXML
    private Label countryCodeCity1;
    @FXML
    private Label countryCodeCity2;

    @FXML
    public void initialize(){
        buttonCity1.disableProperty().bind(this.textFieldCity1.textProperty().isEmpty());
        buttonCity2.disableProperty().bind(this.textFieldCity2.textProperty().isEmpty());
        initControlles();
    }

    private void initControlles() {
        descCity1.setText("");
        countryCodeCity1.setText("");
        tempCity1.setText(Units.temperature);
        feelsLikeCity1.setText(Units.temperature);
        pressureCity1.setText(Units.pressure);
        visibilityCity1.setText(Units.visibility);
        cloudsCity1.setText(Units.cloud);
        humidityCity1.setText(Units.humidity);
        ///
        countryCodeCity2.setText("");
        descCity2.setText("");
        tempCity2.setText(Units.temperature);
        feelsLikeCity2.setText(Units.temperature);
        pressureCity2.setText(Units.pressure);
        visibilityCity2.setText(Units.visibility);
        cloudsCity2.setText(Units.cloud);
        humidityCity2.setText(Units.humidity);
    }

    public void showWeatherCity1() {
        WeatherServiceFactory weatherServiceFactory = new WeatherServiceFactory();
        createView(weatherServiceFactory, textFieldCity1, descCity1, tempCity1, feelsLikeCity1, pressureCity1, visibilityCity1, cloudsCity1, humidityCity1, countryCodeCity1, imageViewCity1);
    }

    private <imageViewCity> void createView(WeatherServiceFactory weatherServiceFactory, TextField textFieldCity, Text descCity, Text tempCity, Text feelsLikeCity, Text pressureCity, Text visibilityCity, Text cloudsCity, Text humidityCity, Label countryCode, ImageView imageViewCity) {
        if(TextValidation.inputValidation(textFieldCity)){
            CurrentWeather currentWeather = weatherServiceFactory.createCurrentWeather(textFieldCity.getText());
            descCity.setText(currentWeather.getDescription());
            countryCode.setText(currentWeather.getCountryCode());
            tempCity.setText(currentWeather.getTemp() + Units.temperature);
            feelsLikeCity.setText(currentWeather.getFeels_like() + Units.temperature);
            pressureCity.setText(currentWeather.getPressure() + Units.pressure);
            visibilityCity.setText(currentWeather.getVisibility() + Units.visibility);
            cloudsCity.setText(currentWeather.getClouds() + Units.cloud);
            humidityCity.setText(currentWeather.getHumidity() + Units.humidity);
            setImage(currentWeather, imageViewCity);

        }
    }

    public void showWeatherCity2() {
        CurrentWeather currentWeather;
        WeatherServiceFactory weatherServiceFactory = new WeatherServiceFactory();
        if(TextValidation.inputValidation(textFieldCity2)){
            currentWeather = weatherServiceFactory.createCurrentWeather(textFieldCity2.getText());
            descCity2.setText(currentWeather.getDescription());
            tempCity2.setText(currentWeather.getTemp() + Units.temperature);
            feelsLikeCity2.setText(currentWeather.getFeels_like() + Units.temperature);
            pressureCity2.setText(currentWeather.getPressure() + Units.pressure);
            visibilityCity2.setText(currentWeather.getVisibility() + Units.visibility);
            cloudsCity2.setText(currentWeather.getClouds() + Units.cloud);
            humidityCity2.setText(currentWeather.getHumidity() + Units.humidity);
            setImage(currentWeather, imageViewCity2);
        }
    }

    private void setImage(CurrentWeather currentWeather, ImageView imageView) {
        String imageSource = currentWeather.getIconURL();
        Image image = new Image(imageSource);
        imageView.setImage(image);
    }
}
