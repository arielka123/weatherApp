package pl.weatherApp.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import pl.weatherApp.model.Directions;
import pl.weatherApp.model.Units;
import pl.weatherApp.model.WeatherCollection;

public class ForecastView {
    private final WeatherCollection weatherCollection;
    private final TilePane tilePaneId;
    private final int days;
    private final Label countryCode;
    private String directions;

    ForecastView(WeatherCollection weatherCollection ,int days,TilePane tilePaneId, Label countryCode){
        this.weatherCollection = weatherCollection;
        this.tilePaneId=tilePaneId;
        this.days=days;
        this.countryCode=countryCode;
    }

    public void create() {
        directions="";
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

            int windValue = weatherCollection.getForecastList(i).getWindDirection();
            directions = Directions.findDirectionName(windValue);

            labelDate1.setText(weatherCollection.getForecastList(i).getTime());
            labelInfo1.setText(weatherCollection.getForecastList(i).getWeather_code());
            labelTempMin.setText("Temperatura: " + weatherCollection.getForecastList(i).getTempMin() + Units.temperature);
            labelFeelsLike1.setText("Temperatura odczuwalna: " + weatherCollection.getForecastList(i).getFeels_likeMin() + Units.temperature);
            labelPrecipitation1.setText("Opady: " + weatherCollection.getForecastList(i).getPrecipitation() + Units.precipitation);
            labelWindSpeed1.setText("Wiatr: " + directions + " " + weatherCollection.getForecastList(i).getWindSpeed() + Units.wind);
            countryCode.setText(weatherCollection.getForecastList(i).getCountryCode());
            countryCode.setTextFill(Color.GRAY);

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
