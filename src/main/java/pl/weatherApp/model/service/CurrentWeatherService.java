package pl.weatherApp.model.service;

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
    //String iconURL = " https://openweathermap.org/img/wn/"+icon+"@2x.png"; //TODO icons for current weather // mapa ?
  //  https://openweathermap.org/weather-conditions

    public CurrentWeatherService(){
        CurrentWeather currentWeather = new CurrentWeather();
        int temp=0;
        int feelsLike = 0;

        try {
            URL url = new URL(WeatherClient.getCurrentWeatherURL());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode_currentWeather: " + responseCode);
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

                if(objMain.get("temp")!=null){
                    temp = Converters.convertDoubleToInt((Double)objMain.get("feels_like"));
                }else{
                    Long tempL = (Long)objMain.get("feels_like");
                    temp = Math.toIntExact(tempL);
                }

                if(objMain.get("feels_like") != null){
                    feelsLike = Converters.convertDoubleToInt((Double)objMain.get("feels_like"));
                }else{
                    Long feelsLikeL= (Long)objMain.get("feels_like");
                    feelsLike = Math.toIntExact(feelsLikeL);
                }

                System.out.println("feelsLike: "+objMain.get("feels_like"));
                System.out.println("temp: "+objMain.get("temp"));

                currentWeather.setTemp(temp);
                currentWeather.setHumidity((Long) objMain.get("humidity"));
                currentWeather.setPressure((Long) objMain.get("pressure"));
                currentWeather.setFeels_like(feelsLike);
                currentWeather.setVisibility((Long) weatherData.get("visibility"));
                currentWeather.setClouds((Long) objClouds.get("all"));
            }
            } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }
}
