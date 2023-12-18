package pl.weatherApp.model.client;

import pl.weatherApp.Config;
import pl.weatherApp.model.utils.DialogUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherClient extends WeatherClient{

        String cityName = "Warsaw";
        {
            try {
                URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid="+ Config.WEATHER_API);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();

                int responseCode = conn.getResponseCode();
                if(responseCode !=200){
                    throw new RuntimeException("HttpResponseCode: "+ responseCode);
                }else{
                    System.out.println("hura!!!!!");
                }
            } catch (IOException e) {
                DialogUtils.errorDialog(e.getMessage());
            }
        }
}
