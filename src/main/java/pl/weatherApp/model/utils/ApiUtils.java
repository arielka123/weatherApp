package pl.weatherApp.model.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiUtils {
    public static HttpURLConnection getHttpURLConnection(URL url) {
        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return conn;
    }

    public static JSONObject getJsonObject(URL url) throws IOException, ParseException {
        StringBuilder informationString = Utils.getStringFromURL(url.openStream());
        JSONParser parse = new JSONParser();
        return (JSONObject) parse.parse(String.valueOf(informationString));
    }
}
