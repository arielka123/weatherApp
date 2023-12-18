package pl.weatherApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.FxmlUtils;
import pl.weatherApp.view.ViewFactory;

import java.io.IOException;
import java.util.ResourceBundle;

public class App extends Application
{
    public static final String BORDER_PAIN_MAIN_FXML = "/fxml/MainBorderPane.fxml";
    public static void main( String[] args )
    {
        launch(args);
    }

    public void start(Stage primaryStage) {

        ViewFactory.loadFXML();
        ViewFactory.showMainWindow(primaryStage);
    }

}
