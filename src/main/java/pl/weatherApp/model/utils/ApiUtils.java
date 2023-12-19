package pl.weatherApp.model.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

    public static JSONObject getJsonObject(Object obj) {
        JSONArray array = new JSONArray();
        array.add(obj);
        JSONObject weatherData = (JSONObject) array.get(0);
        return weatherData;
    }
}
