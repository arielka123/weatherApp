package pl.weatherApp.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.weatherApp.model.WeatherCollection;
import pl.weatherApp.model.service.WeatherServiceFactory;

public class ViewFactory {
    private static ViewFactory instance;
    public static final String DAY_FXML = "/fxml/CurrentDay.fxml";
    public static final String FORECAST_FXML = "/fxml/Forecast.fxml";
    public static final String START_VIEW_FXML = "/fxml/StartView.fxml";
    public static final String BORDER_PAIN_MAIN_FXML = "/fxml/MainBorderPane.fxml";

    private ViewFactory() {
        instance = this;
    }

    public static ViewFactory init(){
        if(instance==null){
            instance= new ViewFactory();
        }
        return instance;
    }
    public void createMainView(Stage primaryStage){
        MainView.showMainWindow(primaryStage);
    }

    public void createForecastView(WeatherCollection weatherCollection , int days, TilePane tilePaneId, Label countryCode){
        ForecastView forecastView = new ForecastView(weatherCollection, days, tilePaneId, countryCode);
        forecastView.create();
    }

    public void createCurrentWeather(WeatherServiceFactory weatherServiceFactory, TextField textField, Text desc, Text temp,Text feelsLike, Text pressure,Text visibility,Text clouds,Text humidity,Label countryCode,ImageView imageView){

        CurrentWeatherView currentWeatherView = new CurrentWeatherView(weatherServiceFactory, textField, desc, temp, feelsLike, pressure, visibility,clouds, humidity, countryCode, imageView);
        currentWeatherView.create();
    }
}
