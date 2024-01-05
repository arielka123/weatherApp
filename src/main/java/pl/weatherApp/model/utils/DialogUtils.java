package pl.weatherApp.model.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class DialogUtils {


    public static void errorDialog(String error){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(FxmlUtils.getResourceBundle().getString("error"));
        errorAlert.setHeaderText(FxmlUtils.getResourceBundle().getString("error"));
        String text = FxmlUtils.getResourceBundle().getString("error.text");
        TextArea textArea = new TextArea(text +"\r\n"+ FxmlUtils.getResourceBundle().getString("error")+": "+ error);
        errorAlert.getDialogPane().setContent(textArea);
        errorAlert.showAndWait();
    }

    public static void inputDialog(){
        Alert inputAlert = new Alert(Alert.AlertType.INFORMATION);
        inputAlert.setTitle(FxmlUtils.getResourceBundle().getString("warningInput"));
        inputAlert.setHeaderText(FxmlUtils.getResourceBundle().getString("warningInput"));
        inputAlert.getDialogPane().setContentText(FxmlUtils.getResourceBundle().getString("warningInput.text"));
        inputAlert.showAndWait();
    }

}
