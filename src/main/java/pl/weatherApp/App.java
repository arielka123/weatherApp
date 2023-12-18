package pl.weatherApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.FxmlUtils;
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

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(BORDER_PAIN_MAIN_FXML));

        ResourceBundle  bundle = FxmlUtils.getResourceBundle();
        loader.setResources(bundle);
        BorderPane borderPane = null;
        try {
            borderPane = loader.load();
        } catch (IOException e) {
            DialogUtils.errorDialog(e.getMessage());
        }
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle(bundle.getString("main.title"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
