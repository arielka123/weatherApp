package pl.weatherApp.model.utils;

import java.io.InputStream;
import java.util.Scanner;

public class ApiUtils {
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
}
