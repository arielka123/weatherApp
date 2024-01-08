package pl.weatherApp.model.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class DialogUtils {
    public static void errorDialog(String error){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(Utils.getResourceBundle().getString("error"));
        errorAlert.setHeaderText(Utils.getResourceBundle().getString("error"));
        String text = Utils.getResourceBundle().getString("error.text");
        TextArea textArea = new TextArea(text +"\r\n"+ Utils.getResourceBundle().getString("error")+": "+ error);
        errorAlert.getDialogPane().setContent(textArea);
        errorAlert.showAndWait();
    }

    public static void inputDialog(){
        Alert inputAlert = new Alert(Alert.AlertType.INFORMATION);
        inputAlert.setTitle(Utils.getResourceBundle().getString("warningInput"));
        inputAlert.setHeaderText(Utils.getResourceBundle().getString("warningInput"));
        inputAlert.getDialogPane().setContentText(Utils.getResourceBundle().getString("warningInput.text"));
        inputAlert.showAndWait();
    }

}
