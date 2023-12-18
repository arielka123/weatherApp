package pl.weatherApp.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import pl.weatherApp.App;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.FxmlUtils;

import java.io.IOException;
import java.util.ResourceBundle;

public class ViewFactory {
    public static ResourceBundle bundle = FxmlUtils.getResourceBundle();

    public static Parent loadFXML(String Path) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(Path));
        loader.setResources(bundle);
        try {
            return loader.load();
        } catch (IOException e) {
            DialogUtils.errorDialog(e.getMessage());
            return null;
        }
    }

}
