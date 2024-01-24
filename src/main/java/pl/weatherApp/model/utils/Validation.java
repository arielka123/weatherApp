package pl.weatherApp.model.utils;

public class Validation {

    public static boolean textValidation(String textFieldCity) {
        String text =removeSpaces(textFieldCity);
        if(text.isEmpty() || containNumbers(text)){
            DialogUtils.inputDialog();
            return false;
        }
        return true;
    }
    private static String removeSpaces(String textFieldCity) {
        if(!textFieldCity.isEmpty()) {
            String newText = textFieldCity.trim();
            return newText;
        }
        return textFieldCity;
    }
    private static boolean containNumbers(String textFieldCity1) {
        return !textFieldCity1.matches("^[a-zA-ZąćęłńóśźżĄĘŁĆŃÓŚŹŻ ]+");
    }
}
