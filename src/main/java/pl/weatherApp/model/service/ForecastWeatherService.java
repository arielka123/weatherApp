package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.client.WeatherClient;
import pl.weatherApp.model.collections.WeatherCodes;
import pl.weatherApp.model.collections.WeatherCollection;
import pl.weatherApp.model.service.objects.ForecastWeather;
import pl.weatherApp.model.service.objects.Location;
import pl.weatherApp.model.utils.DateManager;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.Utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

public class ForecastWeatherService {
    private int responseCode;


    public ForecastWeatherService(){}

    public WeatherCollection init(Location location){
        int days = 16;
        WeatherCollection weatherCollection = new WeatherCollection();

        try {
            URL url = WeatherClient.getForecastURL(location);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode " + this.responseCode);
            } else {
                Utils.informationString = Utils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONObject weatherData = (JSONObject) parse.parse(String.valueOf(Utils.informationString));

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
                    int code = Utils.convertLongToIntArray(weatherCodeArray, i);
                    ForecastWeather dayWeather = new ForecastWeather();

                    addDataToObjDayWeather(tempMaxArray, tempMinArray, feelsLikeMaxArray, feelsLikeMinArray, windSpeedArray, windDirectionArray, timeArray, precipitationArray, i, code, dayWeather, location);
                    weatherCollection.addObjectToForecastList(dayWeather);
                }
            }
        } catch (Exception e) {
            DialogUtils.errorDialog(String.valueOf(this.responseCode));
        }
        return weatherCollection;
    }
    private static void addDataToObjDayWeather(JSONArray tempMaxArray, JSONArray tempMinArray, JSONArray feelsLikeArray, JSONArray feelsLikeMinArray, JSONArray windSpeedArray, JSONArray windDirectionArray, JSONArray timeArray, JSONArray precipitationArray, int i, int code, ForecastWeather dayWeather, Location location) throws ParseException {
        if(windDirectionArray.get(i)!=null) {
            dayWeather.setDateStr((String) timeArray.get(i));
            dayWeather.setWeather_code(WeatherCodes.mapCodes(code));
            dayWeather.setTempMax(Utils.convertDoubleToIntArray(tempMaxArray, i));
            dayWeather.setTempMin(Utils.convertDoubleToIntArray(tempMinArray, i));
            dayWeather.setFeels_likeMax(Utils.convertDoubleToIntArray(feelsLikeArray, i));
            dayWeather.setFeels_likeMin(Utils.convertDoubleToIntArray(feelsLikeMinArray, i));
            dayWeather.setWindSpeed((Double) windSpeedArray.get(i));
            dayWeather.setWindDirection(Utils.convertLongToIntArray(windDirectionArray, i));
            dayWeather.setPrecipitation((Double) precipitationArray.get(i));
            dayWeather.setCountryCode(location.getCountry_code());
            dayWeather.setDayOfWeek(DateManager.getDayOfWeek(dayWeather.getDateStr()));
        }
    }
}

