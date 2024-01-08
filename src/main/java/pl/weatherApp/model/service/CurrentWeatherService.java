package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.client.WeatherClient;
import pl.weatherApp.model.service.objects.CurrentWeather;
import pl.weatherApp.model.service.objects.Location;
import pl.weatherApp.model.utils.Utils;
import pl.weatherApp.model.utils.DialogUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class CurrentWeatherService {
    private String iconNumber=null;
    private int responseCode;

    public CurrentWeather init(Location location){
       CurrentWeather currentWeather = new CurrentWeather();
        int temp;
        int feelsLike;

        try {
            URL url = new URL(WeatherClient.getCurrentWeatherURL(location));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            this.responseCode = conn.getResponseCode();
            if (this.responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + this.responseCode);
            } else {
                Utils.informationString = Utils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONObject weatherData = (JSONObject) parse.parse(String.valueOf(Utils.informationString));

                JSONObject objMain = (JSONObject) weatherData.get("main");
                JSONObject objClouds = (JSONObject) weatherData.get("clouds");
                JSONArray arrayWeather = (JSONArray) weatherData.get("weather");

                for (Object o : arrayWeather) {
                    JSONObject new_obj = (JSONObject) o;
                    currentWeather.setDescription((String) new_obj.get("description"));
                    this.iconNumber = (String) new_obj.get("icon");
                    currentWeather.setIconURL("https://openweathermap.org/img/wn/"+iconNumber+"@2x.png");
                }
                if(objMain.get("temp")!=null){
                    temp = Utils.convertDoubleToInt((Double)objMain.get("temp"));
                }else{
                    Long tempL = (Long)objMain.get("temp");
                    temp = Math.toIntExact(tempL);
                }
                if(objMain.get("feels_like") !=null){
                    feelsLike = Utils.convertDoubleToInt((Double)objMain.get("feels_like"));
                }else{
                    Long feelsLikeL= (Long)objMain.get("feels_like");
                    feelsLike = Math.toIntExact(feelsLikeL);
                }
                currentWeather.setTemp(temp);
                currentWeather.setHumidity((Long) objMain.get("humidity"));
                currentWeather.setPressure((Long) objMain.get("pressure"));
                currentWeather.setFeels_like(feelsLike);
                currentWeather.setVisibility((Long) weatherData.get("visibility"));
                currentWeather.setClouds((Long) objClouds.get("all"));
                currentWeather.setCountryCode(location.getCountry_code());
            }
        } catch (Exception e) {
            DialogUtils.errorDialog(String.valueOf(this.responseCode));
        }
        return currentWeather;
    }
}
