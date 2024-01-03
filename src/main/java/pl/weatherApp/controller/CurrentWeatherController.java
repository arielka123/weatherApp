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
    private TextField textFieldCity1;  //todo input
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

    private CurrentWeather currentWeather;

    @FXML
    public void initialize(){
        this.currentWeather = WeatherServiceFactory.createCurrentWeather();
        this.descCity1.setText("");
        this.tempCity1.setText(Units.temperature);
        this.feelsLikeCity1.setText(Units.temperature);
        this.pressureCity1.setText(Units.pressure);
        this.visibilityCity1.setText(Units.visibility); //TODO cos nie tak z widocznością wyswietla 10000%
        this.cloudsCity1.setText(Units.cloud);
        this.humidityCity1.setText(Units.humidity);

        this.descCity2.setText("");
        this.tempCity2.setText(Units.temperature);
        this.feelsLikeCity2.setText(Units.temperature);
        this.pressureCity2.setText(Units.pressure);
        this.visibilityCity2.setText(Units.visibility); //TODO cos nie tak z widocznością wyswietla 10000%
        this.cloudsCity2.setText(Units.cloud);
        this.humidityCity2.setText(Units.humidity);
    }

    public void showWeatherCity1() {
        this.currentWeather = WeatherServiceFactory.createCurrentWeather();
        this.descCity1.setText(this.currentWeather.getDescription());
        this.tempCity1.setText(this.currentWeather.getTemp()+Units.temperature);
        this.feelsLikeCity1.setText(this.currentWeather.getFeels_like() +Units.temperature);
        this.pressureCity1.setText(this.currentWeather.getPressure() +Units.pressure);
        this.visibilityCity1.setText(this.currentWeather.getVisibility() +Units.visibility);
        this.cloudsCity1.setText(this.currentWeather.getClouds()+Units.cloud);
        this.humidityCity1.setText(this.currentWeather.getHumidity()+Units.humidity);
    }

    public void showWeatherCity2() {
        this.currentWeather = WeatherServiceFactory.createCurrentWeather();
        this.descCity2.setText(this.currentWeather.getDescription());
        this.tempCity2.setText(this.currentWeather.getTemp()+Units.temperature);
        this.feelsLikeCity2.setText(this.currentWeather.getFeels_like() +Units.temperature);
        this.pressureCity2.setText(this.currentWeather.getPressure() +Units.pressure);
        this.visibilityCity2.setText(this.currentWeather.getVisibility() +Units.visibility);
        this.cloudsCity2.setText(this.currentWeather.getClouds()+Units.cloud);
        this.humidityCity2.setText(this.currentWeather.getHumidity()+Units.humidity);
    }
}
