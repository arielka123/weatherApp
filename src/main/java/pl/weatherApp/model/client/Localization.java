package pl.weatherApp.model.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.weatherApp.model.utils.ApiUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Localization {
    private String city = "Warszawa";
    private String country_code;
    private Double latitude;
    private Double longitude;

    public Localization() {
    }

    public void init() {
        try {
            URL url = new URL(WeatherClient.getLocalizationURL());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                ApiUtils.informationString = ApiUtils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONArray localizationData = (JSONArray) parse.parse(String.valueOf(ApiUtils.informationString));

                System.out.println(ApiUtils.informationString);

                for (Object result : localizationData) {
                    JSONObject resultObj = (JSONObject) result;

                    longitude = (Double) resultObj.get("lon");
                    latitude = (Double) resultObj.get("lat");
                    country_code = (String) resultObj.get("country");
                }
                System.out.println("country "+country_code);
                System.out.println("latitude "+latitude);
                System.out.println("longitude "+longitude);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCountry_code() {
        return country_code;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public  String getCity() {
        return city;
    }
}

