package pl.weatherApp.model.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.DialogUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrentWeather {

    public CurrentWeather(){};

    public void init(){

        //$ curl -k 'https://geocoding-api.open-meteo.com/v1/search?name=london&count=10&language=pl&format=json&count=1'

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

                Weather Weather = new Weather();

                for(int i=0; i<arrayWeather.size(); i++){
                      JSONObject new_obj = (JSONObject) arrayWeather.get(i);
                      if(new_obj.get("main").equals("Clouds")){
//                          System.out.println("desc: " + new_obj.get("description"));
                          Weather.setDescription((String) new_obj.get("description"));
                      }
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

                System.out.println(weatherData.get("main"));
            }
            } catch (IOException | ParseException | RuntimeException e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }
}
