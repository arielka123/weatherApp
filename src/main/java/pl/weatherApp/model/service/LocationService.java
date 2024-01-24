package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.weatherApp.model.client.WeatherClient;
import pl.weatherApp.model.service.objects.Location;
import pl.weatherApp.model.utils.Utils;
import pl.weatherApp.model.utils.DialogUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LocationService {
    private final Location location;
    private int responseCode;

    public LocationService(String city) {
        location = new Location();
        location.setCity(city);
    }

    public Location init() {
        try {
            URL url = WeatherClient.getLocationURL(location.getCity());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + this.responseCode);
            } else {
                Utils.informationString = Utils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONArray localizationData = (JSONArray) parse.parse(String.valueOf(Utils.informationString));

                for (Object result : localizationData) {
                    JSONObject resultObj = (JSONObject) result;

                    location.setLongitude((Double) resultObj.get("lon"));
                    location.setLatitude((Double) resultObj.get("lat"));
                    location.setCountry_code((String) resultObj.get("country"));
                }
            }
        } catch (IOException | ParseException e) {
//            throw new RuntimeException(e);
            DialogUtils.errorDialog(String.valueOf(this.responseCode));
        }
        return location;
    }
}
