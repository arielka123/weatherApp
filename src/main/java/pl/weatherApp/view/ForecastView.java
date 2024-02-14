package pl.weatherApp.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import pl.weatherApp.model.objects.collections.Directions;
import pl.weatherApp.model.objects.collections.Units;
import pl.weatherApp.model.objects.collections.ForecastCollection;
import pl.weatherApp.model.utils.Utils;

public class ForecastView {
    private final ForecastCollection forecastCollection;
    private final TilePane tilePaneId;
    private final int days;
    private final Label countryCode;

    ForecastView(ForecastCollection forecastCollection, int days, TilePane tilePaneId, Label countryCode){
        this.forecastCollection = forecastCollection;
        this.tilePaneId=tilePaneId;
        this.days=days;
        this.countryCode=countryCode;
    }

    public void create() {
        for (int i = 0; i < days; i++) {
            TilePane tilePaneInner = new TilePane();

            TilePane.setMargin(tilePaneInner, new Insets(3));

            tilePaneInner.setPrefRows(6);
            tilePaneInner.setPrefColumns(1);
            tilePaneInner.setAlignment(Pos.TOP_CENTER);
            tilePaneInner.setStyle("-fx-background-color:rgb(237,237,237); -fx-background-radius:30;");

            Label labelDate = new Label();
            Label labelDayWeek = new Label();
            Label labelInfo = new Label();
            Label labelFeelsLike = new Label();
            Label labelTempMin = new Label();
            Label labelPrecipitation = new Label();
            Label labelWindSpeed1 = new Label();

            labelFeelsLike.setPadding(new Insets(2));
            countryCode.setTextFill(Color.GRAY);
            labelDayWeek.setStyle("-fx-font-weight: bold");
            labelDate.setFont(Font.font(10));
            labelDate.setTextFill(Color.GRAY);
            labelInfo.setTextFill(Color.valueOf("#2554c7"));

            int windValue = forecastCollection.getOneOfForecastList(i).getWindDirection();
            String directions = Directions.findDirectionName(windValue);

            labelDayWeek.setText(forecastCollection.getOneOfForecastList(i).getDayOfWeek());
            labelDate.setText(forecastCollection.getOneOfForecastList(i).getDateStr());
            labelInfo.setText(forecastCollection.getOneOfForecastList(i).getWeather_code());
            labelTempMin.setText(Utils.getResourceBundle().getString("weather.temperature") +": "+ forecastCollection.getOneOfForecastList(i).getTempMin() + Units.temperature);
            labelFeelsLike.setText(Utils.getResourceBundle().getString("weather.feelsLike") +": "+ forecastCollection.getOneOfForecastList(i).getFeels_likeMin() + Units.temperature);
            labelPrecipitation.setText(Utils.getResourceBundle().getString("weather.precipitation") +": "+ forecastCollection.getOneOfForecastList(i).getPrecipitation() + Units.precipitation);
            labelWindSpeed1.setText(Utils.getResourceBundle().getString("weather.wind") + ": "+ directions + forecastCollection.getOneOfForecastList(i).getWindSpeed() + Units.wind);
            countryCode.setText(forecastCollection.getOneOfForecastList(i).getCountryCode());

            tilePaneInner.getChildren().add(labelDayWeek);
            tilePaneInner.getChildren().add(labelDate);
            tilePaneInner.getChildren().add(labelInfo);
            tilePaneInner.getChildren().add(labelTempMin);
            tilePaneInner.getChildren().add(labelFeelsLike);
            tilePaneInner.getChildren().add(labelPrecipitation);
            tilePaneInner.getChildren().add(labelWindSpeed1);
            tilePaneId.getChildren().add(tilePaneInner);
        }
    }
}
