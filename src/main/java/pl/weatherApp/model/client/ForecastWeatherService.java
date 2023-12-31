package pl.weatherApp.model.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.DialogUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ForecastWeatherService {

    public ForecastWeatherService() {
        int days = 5; //todo user set days

        try {
            URL url = new URL(WeatherClient.getForecastURL());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                ApiUtils.informationString = ApiUtils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONObject weatherData = (JSONObject) parse.parse(String.valueOf(ApiUtils.informationString));

                JSONObject weatherDataObj = (JSONObject) weatherData.get("daily_units");
                String tempUnit = (String) weatherDataObj.get("temperature_2m_max");
                String speedUnit=(String) weatherDataObj.get("wind_speed_10m_max");
                String directionUnit=(String) weatherDataObj.get("wind_direction_10m_dominant");
                String precipitationUnit=(String) weatherDataObj.get("precipitation_sum");

                JSONObject dailyObj = (JSONObject) weatherData.get("daily");

                JSONArray tempMaxArray = (JSONArray) dailyObj.get("temperature_2m_max");
                JSONArray feelsLikeArray = (JSONArray) dailyObj.get("apparent_temperature_max");
                JSONArray windSpeedArray = (JSONArray) dailyObj.get("wind_speed_10m_max");
                JSONArray windDirectionArray = (JSONArray) dailyObj.get("wind_direction_10m_dominant");
                JSONArray timeArray = (JSONArray) dailyObj.get("time");
                JSONArray weatherCodeArray = (JSONArray) dailyObj.get("weather_code");
                JSONArray precipitationArray = (JSONArray) dailyObj.get("precipitation_sum");

                ArrayList<ForecastWeather> daysWeatherList = new ArrayList<>(); //save collections in other class

                for(int i=0; i<days; i++){
                    int code = convertLongToIntArray(weatherCodeArray,i);

                    ForecastWeather dayWeather = new ForecastWeather();
                    dayWeather.setTime((String) timeArray.get(i));
                    dayWeather.setWeather_code(WeatherCodes.mapCodes(code));
                    dayWeather.setTempMax(convertDoubleToIntArray(tempMaxArray, i));
                    dayWeather.setFeels_likeMax(convertDoubleToIntArray(feelsLikeArray, i));
                    dayWeather.setWindSpeed((Double) windSpeedArray.get(i));
                    dayWeather.setWindDirection(convertLongToIntArray(windDirectionArray,i));
                    dayWeather.setPrecipitation((Double) precipitationArray.get(i));
                    daysWeatherList.add(dayWeather);

                    System.out.println(dayWeather.getTime() +" "+dayWeather.getTempMax()+tempUnit+" odczuwalna: "+dayWeather.getFeels_likeMax()+tempUnit+" opady: "+dayWeather.getPrecipitation()+precipitationUnit+" wiatr: "+windSpeedArray.get(i) +speedUnit+" kierunek: "+windDirectionArray.get(i)+directionUnit+" kod: "+ WeatherCodes.mapCodes(code));
                }

//                String sd = daysWeatherList.get(4).getWeather_code();
//                System.out.println(sd);
            }
        } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }

    private static int convertLongToIntArray(JSONArray Array, int i) {
        long nameL = (Long) Array.get(i);
        return Math.toIntExact(nameL);
    }

    private static int convertDoubleToIntArray(JSONArray Array, int i) {
        double nameD = (double) Array.get(i);
        return (int) Math.round(nameD);
    }
}

