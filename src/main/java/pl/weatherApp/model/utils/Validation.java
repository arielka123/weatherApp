package pl.weatherApp.model.utils;

public class Validation {

    public boolean textValidation(String textFieldCity) {
        String text =removeSpaces(textFieldCity);
        if(text.isEmpty() || containNumbers(text)){
            return false;
        }
        return true;
    }
    private String removeSpaces(String textFieldCity) {
        if(!textFieldCity.isEmpty()) {
            String newText = textFieldCity.trim();
            return newText;
        }
        return textFieldCity;
    }
    private boolean containNumbers(String textFieldCity1) {
        return !textFieldCity1.matches("^[a-zA-ZąćęłńóśźżĄĘŁĆŃÓŚŹŻ ]+");
    }
}
