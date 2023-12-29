package pl.weatherApp;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.weatherApp.model.client.Geocoding;
import pl.weatherApp.model.client.WeatherServiceFactory;
import pl.weatherApp.view.ViewFactory;

import java.util.Locale;

public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }
    public void start(Stage primaryStage) {
        Locale.setDefault(new Locale(Geocoding.getLanguage()));

        ViewFactory.createMainView(primaryStage);
        WeatherServiceFactory.createWeatherClient();
    }
}
