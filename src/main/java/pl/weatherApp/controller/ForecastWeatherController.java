package pl.weatherApp.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import pl.weatherApp.model.service.Units;
import pl.weatherApp.model.service.WeatherCollection;
import pl.weatherApp.model.service.WeatherServiceFactory;
import pl.weatherApp.model.utils.TextValidation;

public class ForecastWeatherController {

    @FXML
    private ChoiceBox choiceBoxId;
    @FXML
    private TextField inputCityId;
    @FXML
    private TilePane tilePaneId;
    int days;
    String directions;
    @FXML
    public void initialize(){
        clear();
        choiceBoxId.setItems(FXCollections.observableArrayList(
                "5", "10", "15"
        ));
    }

    public void showOnAction() {
        clear();
        days= Integer.parseInt(choiceBoxId.getSelectionModel().getSelectedItem().toString());

        WeatherCollection weatherCollection;
        WeatherServiceFactory weatherServiceFactory=new WeatherServiceFactory();

        if (TextValidation.inputValidation(inputCityId)) {
            weatherCollection = weatherServiceFactory.createForecastFiveDays(inputCityId.getText());

            for (int i = 0; i < days; i++) {
                TilePane tilePaneInner = new TilePane();

                TilePane.setMargin(tilePaneInner, new Insets(5, 5, 5, 5));
                tilePaneInner.setPrefRows(6);
                tilePaneInner.setPrefColumns(1);
                tilePaneInner.setAlignment(Pos.TOP_CENTER);
                tilePaneInner.setStyle("-fx-background-color:rgb(237,237,237); -fx-background-radius:30;");

                Label labelDate1 = new Label();
                Label labelInfo1 = new Label();
                Label labelFeelsLike1 = new Label();
                Label labelTempMin = new Label();
                Label labelPrecipitation1 = new Label();
                Label labelWindSpeed1 = new Label();

                int windValue = weatherCollection.getForecastList(0).getWindDirection();
                if(windValue==0 || windValue==360){ directions="N";}
                if(windValue>0 && windValue<90){directions="NE";}
                if(windValue==90){directions="E";}
                if(windValue>90 && windValue<180){directions="SE";}
                if(windValue==180){directions="S";}
                if(windValue>180 && windValue<270){directions="SW";}
                if(windValue==270){directions="W";}
                if(windValue>270 && windValue<360){directions="NW";}

                labelDate1.setText(weatherCollection.getForecastList(i).getTime());
                labelInfo1.setText(weatherCollection.getForecastList(i).getWeather_code());
                labelTempMin.setText("Temperatura: " + weatherCollection.getForecastList(i).getTempMin() + Units.temperature);
                labelFeelsLike1.setText("Temperatura odczuwalna: " + weatherCollection.getForecastList(i).getFeels_likeMin() + Units.temperature);
                labelPrecipitation1.setText("Opady: " + weatherCollection.getForecastList(0).getPrecipitation() + Units.precipitation);
                labelWindSpeed1.setText("Wiatr: " +directions+" "+weatherCollection.getForecastList(0).getWindSpeed() + Units.wind);

                labelDate1.setPadding(new Insets(5));
                labelInfo1.setPadding(new Insets(5));
                labelTempMin.setPadding(new Insets(5));
                labelFeelsLike1.setPadding(new Insets(5));
                labelPrecipitation1.setPadding(new Insets(5));
                labelWindSpeed1.setPadding(new Insets(5));

                tilePaneInner.getChildren().add(labelDate1);
                tilePaneInner.getChildren().add(labelInfo1);
                tilePaneInner.getChildren().add(labelTempMin);
                tilePaneInner.getChildren().add(labelFeelsLike1);
                tilePaneInner.getChildren().add(labelPrecipitation1);
                tilePaneInner.getChildren().add(labelWindSpeed1);
                tilePaneId.getChildren().add(tilePaneInner);
            }
        }
    }

    private void clear() {
        tilePaneId.getChildren().clear();
        directions = null;
        days=5;
        choiceBoxId.setValue(5);
    }
}
