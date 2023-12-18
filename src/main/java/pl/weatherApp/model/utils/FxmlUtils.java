package pl.weatherApp.model.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import pl.weatherApp.App;

import java.io.IOException;
import java.util.ResourceBundle;

public class FxmlUtils {

    public static ResourceBundle getResourceBundle(){
        ResourceBundle bundle = ResourceBundle.getBundle("bundle.message");
        return bundle;
    }

    public static Parent loadFXML(String Path) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(Path));
        loader.setResources(getResourceBundle());
        try {
            return loader.load();
        } catch (IOException e) {
            DialogUtils.errorDialog(e.getMessage());
            return null;
        }
    }
}
