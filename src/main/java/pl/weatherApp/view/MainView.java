package pl.weatherApp.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends ViewFactory {

    public static final String BORDER_PAIN_MAIN_FXML = "/fxml/MainBorderPane.fxml";

    public static final BorderPane MAIN_VIEW = (BorderPane) loadFXML(BORDER_PAIN_MAIN_FXML);
    private static final Scene scene = new Scene(MAIN_VIEW);

    public static void showMainWindow(Stage primaryStage) {
        primaryStage.setTitle(bundle.getString("main.title"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
