package pl.weatherApp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import pl.weatherApp.model.service.CurrentWeather;
import pl.weatherApp.model.service.Units;
import pl.weatherApp.model.service.WeatherServiceFactory;

public class CurrentWeatherController {
    //todo bundlesy

    @FXML
    private TextField textFieldCity1;
    @FXML
    private TextField TextFieldCity2;

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
    public void initialize(){
        descCity1.setText("");
        tempCity1.setText(Units.temperature);
        feelsLikeCity1.setText(Units.temperature);
        pressureCity1.setText(Units.pressure);
        visibilityCity1.setText(Units.visibility);
        cloudsCity1.setText(Units.cloud);
        humidityCity1.setText(Units.humidity);
        descCity2.setText("");
        tempCity2.setText(Units.temperature);
        feelsLikeCity2.setText(Units.temperature);
        pressureCity2.setText(Units.pressure);
        visibilityCity2.setText(Units.visibility);
        cloudsCity2.setText(Units.cloud);
        humidityCity2.setText(Units.humidity);
    }

    public void showWeatherCity1() {
        CurrentWeather currentWeather;
        WeatherServiceFactory weatherServiceFactory = new WeatherServiceFactory();
        if(textFieldCity1==null){
            //todo dialogs when something is wrong with city string or is null
        }
        currentWeather = weatherServiceFactory.createCurrentWeather(textFieldCity1.getText());
        descCity1.setText(currentWeather.getDescription());
        tempCity1.setText(currentWeather.getTemp()+Units.temperature);
        feelsLikeCity1.setText(currentWeather.getFeels_like() +Units.temperature);
        pressureCity1.setText(currentWeather.getPressure() +Units.pressure);
        visibilityCity1.setText(currentWeather.getVisibility() +Units.visibility);
        cloudsCity1.setText(currentWeather.getClouds()+Units.cloud);
        humidityCity1.setText(currentWeather.getHumidity()+Units.humidity);
    }

    public void showWeatherCity2() {
        CurrentWeather currentWeather;
        WeatherServiceFactory weatherServiceFactory = new WeatherServiceFactory();
        currentWeather = weatherServiceFactory.createCurrentWeather(TextFieldCity2.getText());
        descCity2.setText(currentWeather.getDescription());
        tempCity2.setText(currentWeather.getTemp()+Units.temperature);
        feelsLikeCity2.setText(currentWeather.getFeels_like() +Units.temperature);
        pressureCity2.setText(currentWeather.getPressure() +Units.pressure);
        visibilityCity2.setText(currentWeather.getVisibility() +Units.visibility);
        cloudsCity2.setText(currentWeather.getClouds()+Units.cloud);
        humidityCity2.setText(currentWeather.getHumidity()+Units.humidity);
    }
}
