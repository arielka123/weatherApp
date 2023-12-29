package pl.weatherApp.model.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.DialogUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class ForecastWeather {

    public ForecastWeather() {
        ForecastWeatherParam forecastWeatherParam = new ForecastWeatherParam();
        int days = 5;

        try {
            URL url = new URL(WeatherClient.getFiveDaysForecastURL());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                ApiUtils.informationString = ApiUtils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONObject weatherData = (JSONObject) parse.parse(String.valueOf(ApiUtils.informationString));

                System.out.println(weatherData.get("daily_units"));

                JSONObject weatherDataObj = (JSONObject) weatherData.get("daily_units");
                System.out.println(weatherDataObj);
                String tempUnit = (String) weatherDataObj.get("temperature_2m_max");
                String speedUnit=(String) weatherDataObj.get("wind_speed_10m_max");
                String directionUnit=(String) weatherDataObj.get("wind_direction_10m_dominant");

                JSONObject dailyObj = (JSONObject) weatherData.get("daily");

                JSONArray tempMaxArray = (JSONArray) dailyObj.get("temperature_2m_max");
                JSONArray feelsLikeArray = (JSONArray) dailyObj.get("apparent_temperature_max");
                JSONArray windSpeedArray = (JSONArray) dailyObj.get("wind_speed_10m_max");
                JSONArray windDirectionArray = (JSONArray) dailyObj.get("wind_direction_10m_dominant");
                JSONArray timeArray = (JSONArray) dailyObj.get("time");
                JSONArray weatherCodeArray = (JSONArray) dailyObj.get("weather_code");
                JSONArray precipitationArray = (JSONArray) dailyObj.get("precipitation_sum");

                long codeL = (Long) weatherCodeArray.get(1);
                int code = Math.toIntExact(codeL);
                System.out.println(code);
                System.out.println("kod: "+WeatherCodes.mapCodes(code));

                for(int i=0; i<days; i++){
                    System.out.println(timeArray.get(i) +" "+tempMaxArray.get(i)+tempUnit+" odczuwalna: "+feelsLikeArray.get(i)+tempUnit+" opady: "+precipitationArray.get(i)+" wiatr: "+windSpeedArray.get(i) +speedUnit+" kierunek: "+windDirectionArray.get(i)+directionUnit+" kod: "+ weatherCodeArray.get(i));
                }
            }
        } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }
}

