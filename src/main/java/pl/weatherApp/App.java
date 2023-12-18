package pl.weatherApp;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.weatherApp.model.client.WeatherServiceFactory;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.view.MainView;
import pl.weatherApp.view.ViewFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }
    public void start(Stage primaryStage) {
        ViewFactory.createMainView(primaryStage);
        WeatherServiceFactory.createWeatherClient();
    }
}
