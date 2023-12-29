package pl.weatherApp.model.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.DialogUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class Localization {
    private String city ;
    private String country_code;
    private String  country;

    private Double latitude;
    private Double longitude;

    public Localization() {
    }

    public void init() {
        try {
            URL url = new URL(WeatherClient.getLocatizationURL());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                ApiUtils.informationString = ApiUtils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONObject localizationData = (JSONObject) parse.parse(String.valueOf(ApiUtils.informationString));

                System.out.println(ApiUtils.informationString);

                JSONArray results = (JSONArray) localizationData.get("results");

                for (Object result : results) {
                    JSONObject resultObj = (JSONObject) result;

                    longitude = (Double) resultObj.get("longitude");
                    latitude = (Double) resultObj.get("latitude");
                    city = (String) resultObj.get("name");
                    country = (String) resultObj.get("country");
                    country_code = (String) resultObj.get("country_code");
                }
            }
        } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }

    public String getCity() {
        return city;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getCountry() {
        return country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
