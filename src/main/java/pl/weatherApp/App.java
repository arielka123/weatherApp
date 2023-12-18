package pl.weatherApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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

        loader.setResources(ResourceBundle.getBundle("bundle.message"));
        ResourceBundle  bundle = ResourceBundle.getBundle("bundle.message");
        loader.setResources(bundle);
        BorderPane borderPane;
        try {
            borderPane = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);  //TODO
        }
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle(bundle.getString("main.title"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
