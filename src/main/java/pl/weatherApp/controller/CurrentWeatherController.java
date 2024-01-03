package pl.weatherApp.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import pl.weatherApp.model.service.CurrentWeather;
import pl.weatherApp.model.service.Units;
import pl.weatherApp.model.service.WeatherServiceFactory;

public class CurrentWeatherController {
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
    }

    public void showWeatherCity1() {
        this.currentWeather = WeatherServiceFactory.createCurrentWeather();
        this.descCity1.setText(this.currentWeather.getDescription());
        this.tempCity1.setText(this.currentWeather.getTemp()+Units.temperature);
        this.feelsLikeCity1.setText(this.currentWeather.getFeels_like() +Units.temperature);
        this.pressureCity1.setText(this.currentWeather.getPressure() +Units.pressure);
//        this.visibilityCity1.setText(this.currentWeather.getVisibility() +Units.visibility);
        this.visibilityCity1.setText(Long.toString(this.currentWeather.getVisibility()));
        this.cloudsCity1.setText(this.currentWeather.getClouds()+Units.cloud);
        this.humidityCity1.setText(this.currentWeather.getHumidity()+Units.humidity);
    }
}
