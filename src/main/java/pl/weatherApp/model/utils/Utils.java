package pl.weatherApp.model.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.json.simple.JSONArray;
import pl.weatherApp.App;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Utils {
    public static StringBuilder informationString = new StringBuilder();

    public static StringBuilder getStringFromURL(InputStream inputStream){
        informationString = null;
        StringBuilder informationString = new StringBuilder();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            informationString.append(scanner.nextLine());
        }
        scanner.close();
        return informationString;
    }

    public static int convertDoubleToInt(double name){
        return (int) Math.round(name);
    }

    public static int convertLongToIntArray(JSONArray Array, int i) {
        long nameL = (Long) Array.get(i);
        return Math.toIntExact(nameL);
    }

    public static int convertDoubleToIntArray(JSONArray Array, int i) {
        double nameD = (double) Array.get(i);
        return (int) Math.round(nameD);
    }

    public static ResourceBundle getResourceBundle(){
        return ResourceBundle.getBundle("bundle.message");
    }

    public static String getBundle(String name){
        return Utils.getResourceBundle().getString(name);
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
