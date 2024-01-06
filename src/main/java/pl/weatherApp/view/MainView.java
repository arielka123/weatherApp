package pl.weatherApp.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.weatherApp.model.utils.FxmlUtils;

public class MainView extends ViewFactory {

    public static final String BORDER_PAIN_MAIN_FXML = "/fxml/MainBorderPane.fxml";
    public static final BorderPane MAIN_VIEW = (BorderPane) FxmlUtils.loadFXML(BORDER_PAIN_MAIN_FXML);
    private static final Scene scene = new Scene(MAIN_VIEW);

    public static void showMainWindow(Stage primaryStage) {
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("main.title"));
//        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
