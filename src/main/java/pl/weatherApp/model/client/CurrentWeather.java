package pl.weatherApp.model.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.DialogUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class CurrentWeather {

    public CurrentWeather(){
        init();
    }

    public void init(){
        Weather Weather = new Weather();

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

                System.out.println(weatherData.get("weather"));

                for (Object o : arrayWeather) {
                    JSONObject new_obj = (JSONObject) o;
                    Weather.setDescription((String) new_obj.get("description"));
                }

                try{
                    Weather.setTemp((Double) objMain.get("temp"));
                }catch (Exception e){
                    Weather.setTemp((Long) objMain.get("temp"));
                }

                Weather.setTemp((Double) objMain.get("temp"));
                Weather.setHumidity((Long) objMain.get("humidity"));
                Weather.setPressure((Long) objMain.get("pressure"));
                Weather.setFeels_like((Double) objMain.get("feels_like"));
                Weather.setVisibility((Long) weatherData.get("visibility"));
                Weather.setClouds((Long) objClouds.get("all"));

                System.out.println("Opis: "+ Weather.getDescription());
                System.out.println("Temperatura: "+ Weather.getTemp());
                System.out.println("Temp odczuwalna: "+ Weather.getFeels_like());
                System.out.println("Ciśnienie: "+ Weather.getPressure());
                System.out.println("Wilgotność: "+ Weather.getHumidity());
                System.out.println("Zachmurzenie: "+ Weather.getClouds());
                System.out.println("Widoczność: "+ Weather.getVisibility());

            }
            } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }
}
