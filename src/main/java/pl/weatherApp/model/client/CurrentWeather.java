package pl.weatherApp.model.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.DialogUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class CurrentWeather {
    String icon;
    //String iconURL = " https://openweathermap.org/img/wn/"+icon+"@2x.png"; //TODO
  //  https://openweathermap.org/weather-conditions

    public CurrentWeather(){
        Localization localization = new Localization(); //todo
        CurrentWeatherParam currentWeatherParam = new CurrentWeatherParam();

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
                    currentWeatherParam.setDescription((String) new_obj.get("description"));
                    icon = (String) new_obj.get("icon"); //TODO
                }

                double tempD= (double) objMain.get("temp");
                int temp = (int) Math.round(tempD);

                currentWeatherParam.setTemp(temp);
                currentWeatherParam.setHumidity((Long) objMain.get("humidity"));
                currentWeatherParam.setPressure((Long) objMain.get("pressure"));
                currentWeatherParam.setFeelsLike((double) objMain.get("feels_like"));
                currentWeatherParam.setVisibility((Long) weatherData.get("visibility"));
                currentWeatherParam.setClouds((Long) objClouds.get("all"));

                System.out.println("Miasto: "+localization.getCity());
                System.out.println("Opis: "+ currentWeatherParam.getDescription());
                System.out.println("Temperatura: "+ currentWeatherParam.getTemp());
                System.out.println("Temp odczuwalna: "+ currentWeatherParam.getFeels_like());
                System.out.println("Ciśnienie: "+ currentWeatherParam.getPressure());
                System.out.println("Wilgotność: "+ currentWeatherParam.getHumidity());
                System.out.println("Zachmurzenie: "+ currentWeatherParam.getClouds());
                System.out.println("Widoczność: "+ currentWeatherParam.getVisibility());
            }
            } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }

}
