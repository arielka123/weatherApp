package pl.weatherApp.controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pl.weatherApp.model.service.Units;
import pl.weatherApp.model.service.WeatherCollection;
import pl.weatherApp.model.service.WeatherServiceFactory;

public class ForecastWeatherController {

    @FXML
    private VBox VBoxId;

    @FXML
    public void initialize(){

        show();
    }

    private void show() {
        WeatherCollection weatherCollection;
        WeatherServiceFactory weatherServiceFactory = new WeatherServiceFactory();

        weatherCollection = weatherServiceFactory.createForecastFiveDays("Warsaw");

        for(int i=0; i<5;i++){
            Label labelDate1 = new Label();
            Label labelInfo1 = new Label();
            Label labelFeelsLike1 = new Label();
            Label labelTemp1 = new Label();
            Label labelPrecipitation1 = new Label();
            Label labelWindSpeed1 = new Label();

            labelDate1.setText(weatherCollection.getForecastList(i).getTime());
            labelInfo1.setText(weatherCollection.getForecastList(i).getWeather_code());
            labelTemp1.setText(weatherCollection.getForecastList(i).getTempMin()+ Units.temperature);
            labelFeelsLike1.setText(weatherCollection.getForecastList(i).getFeels_likeMin()+Units.temperature);
            labelPrecipitation1.setText(weatherCollection.getForecastList(0).getPrecipitation() + Units.precipitation2);
            labelWindSpeed1.setText(weatherCollection.getForecastList(0).getWindSpeed() + Units.wind);

            labelDate1.setPadding(new Insets(5));
            labelInfo1.setPadding(new Insets(5));
            labelTemp1.setPadding(new Insets(5));
            labelFeelsLike1.setPadding(new Insets(5));
            labelPrecipitation1.setPadding(new Insets(5));
            labelWindSpeed1.setPadding(new Insets(5));

            HBox hbox = new HBox();
            hbox.getChildren().add(labelDate1);
            hbox.getChildren().add(labelInfo1);
            hbox.getChildren().add(labelTemp1);
            hbox.getChildren().add(labelFeelsLike1);
            hbox.getChildren().add(labelPrecipitation1);
            hbox.getChildren().add(labelWindSpeed1);

            VBoxId.getChildren().add(hbox);
        }

    }
}
