package pl.weatherApp.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pl.weatherApp.model.objects.collections.ForecastCollection;
import pl.weatherApp.model.service.WeatherServiceManager;

public class ViewManager {
    private static ViewManager instance;
    public static final String DAY_FXML = "/fxml/CurrentDay.fxml";
    public static final String FORECAST_FXML = "/fxml/Forecast.fxml";
    public static final String START_VIEW_FXML = "/fxml/StartView.fxml";
    public static final String BORDER_PAIN_MAIN_FXML = "/fxml/MainBorderPane.fxml";

    private ViewManager() {
        instance = this;
    }

    public static ViewManager init(){
        if(instance==null){
            instance= new ViewManager();
        }
        return instance;
    }
    public void createMainView(Stage primaryStage){
        MainView.showMainWindow(primaryStage);
    }

    public void createForecastView(ForecastCollection forecastCollection, int days, TilePane tilePaneId, Label countryCode){
        ForecastView forecastView = new ForecastView(forecastCollection, days, tilePaneId, countryCode);
        forecastView.create();
    }

    public void createCurrentWeather(WeatherServiceManager weatherServiceManager, TextField textField, Text desc, Text temp, Text feelsLike, Text pressure, Text visibility, Text clouds, Text humidity, Label countryCode, ImageView imageView){

        CurrentWeatherView currentWeatherView = new CurrentWeatherView(weatherServiceManager, textField, desc, temp, feelsLike, pressure, visibility,clouds, humidity, countryCode, imageView);
        currentWeatherView.create();
    }
}
