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
    private String city=null;
    private String country_code=null;
    private Double latitude=null;
    private Double longitude=null;

    public LocalizationService(String city){
        this.setCity(city);
    }

    public void init() {
     try {
            URL url = new URL(WeatherClient.getLocalizationURL(this));
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

                    LocalizationService localizationService = new LocalizationService(getCity());
                    localizationService.longitude = (Double) resultObj.get("lon");
                    localizationService.latitude = (Double) resultObj.get("lat");
                    localizationService.country_code = (String) resultObj.get("country");
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public  String getCountry_code() {
        return country_code;
    }

    public  Double getLatitude() {
        return latitude;
    }

    public  Double getLongitude() {
        return longitude;
    }

    public  String getCity() {
        return city;
    }

    public  void setCity(String city) {
        this.city = city;
    }
}

