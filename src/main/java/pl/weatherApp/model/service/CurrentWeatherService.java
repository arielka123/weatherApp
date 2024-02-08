package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.weatherApp.model.client.WeatherClient;
import pl.weatherApp.model.objects.CurrentWeather;
import pl.weatherApp.model.objects.Location;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.Utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrentWeatherService implements IWeatherService{
    CurrentWeather currentWeather;
    int responseCode;
    String countryCode;
    String description;
    int temp;
    int feelsLike;
    Long humidity;
    Long pressure;
    Long visibility;
    Long clouds;
    String iconURL;

    public CurrentWeather init(Location location) {

        try {
            URL url = WeatherClient.getCurrentWeatherURL(location);

            HttpURLConnection conn = getHttpURLConnection(url);
            responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                JSONObject weatherData = getJsonObject(url);

                JSONObject objMain = (JSONObject) weatherData.get("main");
                JSONObject objClouds = (JSONObject) weatherData.get("clouds");
                JSONArray arrayWeather = (JSONArray) weatherData.get("weather");

                for (Object o : arrayWeather) {
                    JSONObject new_obj = (JSONObject) o;
                    String iconNumber = (String) new_obj.get("icon");

                    description = (String) new_obj.get("description");
                    iconURL = "https://openweathermap.org/img/wn/" + iconNumber + "@2x.png";
                }
                if (objMain.get("temp") != null) {
                    temp = Utils.convertDoubleToInt((Double) objMain.get("temp"));
                } else {
                    Long tempL = (Long) objMain.get("temp");
                    temp = Math.toIntExact(tempL);
                }
                if (objMain.get("feels_like") != null) {
                    feelsLike = Utils.convertDoubleToInt((Double) objMain.get("feels_like"));
                } else {
                    Long feelsLikeL = (Long) objMain.get("feels_like");
                    feelsLike = Math.toIntExact(feelsLikeL);
                }
                countryCode = location.getCountry_code();
                humidity = (Long) objMain.get("humidity");
                pressure = (Long) objMain.get("pressure");
                visibility = (Long) weatherData.get("visibility");
                clouds = (Long) objClouds.get("all");

                currentWeather = new CurrentWeather(countryCode, description, temp, feelsLike, humidity, pressure, visibility, clouds, iconURL);
            }
        } catch (Exception e) {
            if (responseCode == 200) {
                DialogUtils.errorDialog("");
            } else {
                DialogUtils.errorDialog(String.valueOf(responseCode));
            }
        }
        return currentWeather;
    }

    public HttpURLConnection getHttpURLConnection(URL url) {
        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    private JSONObject getJsonObject(URL url) throws IOException, ParseException {
        StringBuilder informationString = Utils.getStringFromURL(url.openStream());
        JSONParser parse = new JSONParser();
        return (JSONObject) parse.parse(String.valueOf(informationString));
    }

    public int getResponseCode() {
        return responseCode;
    }
}
