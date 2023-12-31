package pl.weatherApp.model.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.Converters;
import pl.weatherApp.model.utils.DialogUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class CurrentWeatherService {
    String icon;
    //String iconURL = " https://openweathermap.org/img/wn/"+icon+"@2x.png"; //TODO
  //  https://openweathermap.org/weather-conditions

    public CurrentWeatherService(){
//        Localization localization = new Localization(); //todo
        CurrentWeather currentWeather = new CurrentWeather();

        try {
            URL url = new URL(WeatherClient.getCurrentWeatherURL());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                ApiUtils.informationString = ApiUtils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONObject weatherData = (JSONObject) parse.parse(String.valueOf(ApiUtils.informationString));

                JSONObject objMain = (JSONObject) weatherData.get("main");
                JSONObject objClouds = (JSONObject) weatherData.get("clouds");
                JSONArray arrayWeather = (JSONArray) weatherData.get("weather");

                for (Object o : arrayWeather) {
                    JSONObject new_obj = (JSONObject) o;
                    currentWeather.setDescription((String) new_obj.get("description"));
                    icon = (String) new_obj.get("icon"); //TODO
                }
                int temp = Converters.convertDoubleToInt((double) objMain.get("temp"));

                currentWeather.setTemp(temp);
                currentWeather.setHumidity((Long) objMain.get("humidity"));
                currentWeather.setPressure((Long) objMain.get("pressure"));
                currentWeather.setFeelsLike((Double) objMain.get("feels_like"));
                currentWeather.setVisibility((Long) weatherData.get("visibility"));
                currentWeather.setClouds((Long) objClouds.get("all"));
            }
            } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }
}
