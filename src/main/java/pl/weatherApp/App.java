package pl.weatherApp;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.weatherApp.view.ViewManager;

import java.util.Locale;

public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }
    public void start(Stage primaryStage) {
//        Config.setCharset();

        Locale.setDefault(new Locale(Config.language));
        ViewManager viewManager = ViewManager.init();
        viewManager.createMainView(primaryStage);
    }
}
