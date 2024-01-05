package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.weatherApp.model.utils.ApiUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LocationService {
    private String city;
    private String country_code;
    private Double latitude;
    private Double longitude;

    public LocationService(String city){
        this.setCity(city);
    }

    public void init() {
     try {
            URL url = new URL(WeatherClient.getLocationURL(getCity()));
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

                    this.setLongitude((Double) resultObj.get("lon"));
                    this.setLatitude((Double) resultObj.get("lat"));
                    this.setCountry_code((String) resultObj.get("country"));
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public  String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public  Double getLatitude() {
        return latitude;
    }

    public  Double getLongitude() {
        return longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public  String getCity() {
        return city;
    }

    public  void setCity(String city) {
        this.city = city;
    }
}

