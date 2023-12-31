package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.weatherApp.model.utils.ApiUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LocalizationService {
    private static String city;
    private static String country_code;
    private static Double latitude;
    private static Double longitude;

    public LocalizationService(){
        LocalizationService.setCity("Warszawa"); //TODO user set city
    };

    public void init() {
     try {
            URL url = new URL(WeatherClient.getLocalizationURL());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode _ Localization: " + responseCode);
            } else {
                ApiUtils.informationString = ApiUtils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONArray localizationData = (JSONArray) parse.parse(String.valueOf(ApiUtils.informationString));

                for (Object result : localizationData) {
                    JSONObject resultObj = (JSONObject) result;

                    LocalizationService.longitude = (Double) resultObj.get("lon");
                    LocalizationService.latitude = (Double) resultObj.get("lat");
                    LocalizationService.country_code = (String) resultObj.get("country");
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCountry_code() {
        return country_code;
    }

    public static Double getLatitude() {
        return latitude;
    }

    public static Double getLongitude() {
        return longitude;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        LocalizationService.city = city;
    }
}

