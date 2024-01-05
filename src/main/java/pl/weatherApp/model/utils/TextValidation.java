package pl.weatherApp.model.utils;

import javafx.scene.control.TextField;

public class TextValidation {

    public static boolean inputValidation (TextField textFieldCity) {
        removeSpaces(textFieldCity);
        if(textFieldCity.getText().isEmpty() || containNumbers(textFieldCity)){
            DialogUtils.inputDialog();
            return false;
        }
        return true;
    }
    private static void removeSpaces(TextField textFieldCity) {
        if(!textFieldCity.getText().isEmpty()) {
            String newText = textFieldCity.getText().trim();
            textFieldCity.setText(newText);
        }
    }
    private static boolean containNumbers(TextField textFieldCity1) {
        return !textFieldCity1.getText().matches("^[a-zA-ZąćęłńóśźżĄĘŁĆŃÓŚŹŻ ]+");
    }
}
