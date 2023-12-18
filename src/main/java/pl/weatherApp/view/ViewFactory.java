package pl.weatherApp.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.weatherApp.App;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.FxmlUtils;

import java.io.IOException;
import java.util.ResourceBundle;

public class ViewFactory {

    public static final String BORDER_PAIN_MAIN_FXML = "/fxml/MainBorderPane.fxml";
    public static final BorderPane MAIN_VIEW = (BorderPane) loadFXML();
    private static final Scene scene = new Scene(MAIN_VIEW);
    public static ResourceBundle  bundle = FxmlUtils.getResourceBundle();

    public static Parent loadFXML() {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(BORDER_PAIN_MAIN_FXML));
        loader.setResources(bundle);
        try {
            return loader.load();
        } catch (IOException e) {
            DialogUtils.errorDialog(e.getMessage());
            return null;
        }
    }
    public static void showMainWindow(Stage primaryStage) {
        primaryStage.setTitle(bundle.getString("main.title"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
