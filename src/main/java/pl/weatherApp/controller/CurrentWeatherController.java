package pl.weatherApp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class CurrentWeatherController extends BaseController{
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
    }

    public void showWeatherCity1() {
        viewManager.createCurrentWeather(weatherServiceManager, textFieldCity1, descCity1, tempCity1, feelsLikeCity1, pressureCity1, visibilityCity1, cloudsCity1, humidityCity1, countryCodeCity1, imageViewCity1);
    }

    public void showWeatherCity2() {
        viewManager.createCurrentWeather(weatherServiceManager, textFieldCity2, descCity2, tempCity2, feelsLikeCity2, pressureCity2, visibilityCity2,cloudsCity2, humidityCity2, countryCodeCity2, imageViewCity2);
    }
}
