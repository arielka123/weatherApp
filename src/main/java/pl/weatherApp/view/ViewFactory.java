package pl.weatherApp.view;

import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import pl.weatherApp.model.WeatherCollection;

public class ViewFactory {
    public static void createMainView(Stage primaryStage){
        MainView.showMainWindow(primaryStage);
    }

    public void createForecastView(WeatherCollection weatherCollection , int days, TilePane tilePaneId){
        ForecastView forecastView = new ForecastView(weatherCollection, days, tilePaneId);
        forecastView.createForecastView();
    }
}
