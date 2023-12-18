package pl.weatherApp.model.Utils;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.util.ResourceBundle;

public class DialogUtils {


    public static void errorDialog(String error){

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(FxmlUtils.getResourceBundle().getString("error"));
        errorAlert.setHeaderText(FxmlUtils.getResourceBundle().getString("error"));
        String text = FxmlUtils.getResourceBundle().getString("error.text");
        TextArea textArea = new TextArea(text +"\r\n"+ error);
        errorAlert.getDialogPane().setContent(textArea);
        errorAlert.showAndWait();
    }

}
