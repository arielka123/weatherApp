package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.weatherApp.model.client.WeatherClient;
import pl.weatherApp.model.service.objects.CurrentWeather;
import pl.weatherApp.model.service.objects.Location;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.Utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrentWeatherService {
    private CurrentWeather currentWeather;
    private int responseCode;

    public CurrentWeather init(Location location){
        int temp;
        int feelsLike;

        try {
            URL url = WeatherClient.getCurrentWeatherURL(location);

            HttpURLConnection conn = getHttpURLConnection(url);
            this.responseCode = conn.getResponseCode();

            if (this.responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + this.responseCode);
            } else {
                JSONObject weatherData = getJsonObject(url);

                JSONObject objMain = (JSONObject) weatherData.get("main");
                JSONObject objClouds = (JSONObject) weatherData.get("clouds");
                JSONArray arrayWeather = (JSONArray) weatherData.get("weather");

                for (Object o : arrayWeather) {
                    currentWeather= new CurrentWeather();
                    JSONObject new_obj = (JSONObject) o;
                    currentWeather.setDescription((String) new_obj.get("description"));
                    String iconNumber = (String) new_obj.get("icon");
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
            if(responseCode==200){
                DialogUtils.errorDialog("");
            }else{
                DialogUtils.errorDialog(String.valueOf(this.responseCode));
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
