package pl.weatherApp.model.Utils;

import java.util.ResourceBundle;

public class FxmlUtils {

    public static ResourceBundle getResourceBundle(){
        ResourceBundle bundle = ResourceBundle.getBundle("bundle.message");
        return bundle;
    }


}
