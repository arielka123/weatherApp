package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.WeatherCodes;
import pl.weatherApp.model.WeatherCollection;
import pl.weatherApp.model.client.WeatherClient;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.Converters;
import pl.weatherApp.model.utils.DialogUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class ForecastWeatherService {
    public ForecastWeatherService(){}

    public WeatherCollection init(Location location){
        int days = 16;
        ForecastWeather dayWeather;
        WeatherCollection weatherCollection = new WeatherCollection();

        try {
            URL url = new URL(WeatherClient.getForecastURL(location));

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode_Forecast: " + responseCode);
            } else {
                ApiUtils.informationString = ApiUtils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONObject weatherData = (JSONObject) parse.parse(String.valueOf(ApiUtils.informationString));

                JSONObject dailyObj = (JSONObject) weatherData.get("daily");
                JSONArray tempMaxArray = (JSONArray) dailyObj.get("temperature_2m_max");
                JSONArray tempMinArray = (JSONArray) dailyObj.get("temperature_2m_min");
                JSONArray feelsLikeMaxArray = (JSONArray) dailyObj.get("apparent_temperature_max");
                JSONArray feelsLikeMinArray = (JSONArray) dailyObj.get("apparent_temperature_min");
                JSONArray windSpeedArray = (JSONArray) dailyObj.get("wind_speed_10m_max");
                JSONArray windDirectionArray = (JSONArray) dailyObj.get("wind_direction_10m_dominant");
                JSONArray timeArray = (JSONArray) dailyObj.get("time");
                JSONArray weatherCodeArray = (JSONArray) dailyObj.get("weather_code");
                JSONArray precipitationArray = (JSONArray) dailyObj.get("precipitation_sum");

                for (int i = 0; i < days; i++) {
                    int code = Converters.convertLongToIntArray(weatherCodeArray, i);
                    dayWeather = new ForecastWeather();

                    addDataToObjDayWeather(tempMaxArray, tempMinArray, feelsLikeMaxArray, feelsLikeMinArray, windSpeedArray, windDirectionArray, timeArray, precipitationArray, i, code, dayWeather);

                    weatherCollection.addObjectToForecastList(dayWeather);
                }
            }
        } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
        return weatherCollection;
    }
    private static void addDataToObjDayWeather(JSONArray tempMaxArray, JSONArray tempMinArray, JSONArray feelsLikeArray, JSONArray feelsLikeMinArray, JSONArray windSpeedArray, JSONArray windDirectionArray, JSONArray timeArray, JSONArray precipitationArray, int i, int code, ForecastWeather dayWeather) {
        if(windDirectionArray.get(i)!=null) {
            dayWeather.setTime((String) timeArray.get(i));
            dayWeather.setWeather_code(WeatherCodes.mapCodes(code));
            dayWeather.setTempMax(Converters.convertDoubleToIntArray(tempMaxArray, i));
            dayWeather.setTempMin(Converters.convertDoubleToIntArray(tempMinArray, i));
            dayWeather.setFeels_likeMax(Converters.convertDoubleToIntArray(feelsLikeArray, i));
            dayWeather.setFeels_likeMin(Converters.convertDoubleToIntArray(feelsLikeMinArray, i));
            dayWeather.setWindSpeed((Double) windSpeedArray.get(i));
            dayWeather.setWindDirection(Converters.convertLongToIntArray(windDirectionArray, i));
            dayWeather.setPrecipitation((Double) precipitationArray.get(i));
        }
    }
}

