package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.client.WeatherClient;
import pl.weatherApp.model.objects.collections.WeatherCodes;
import pl.weatherApp.model.objects.collections.ForecastCollection;
import pl.weatherApp.model.objects.ForecastWeather;
import pl.weatherApp.model.objects.Location;
import pl.weatherApp.model.utils.DateManager;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.Utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

public class ForecastWeatherService extends IService{
    private int responseCode;
    public int getResponseCode() {
        return responseCode;
    }
    public ForecastWeatherService(){}

    public ForecastCollection init(Location location){
        int days = 16;
        ForecastCollection forecastCollection = new ForecastCollection();

        try {
            URL url = WeatherClient.getForecastURL(location);

            HttpURLConnection conn = getHttpURLConnection(url);
            responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode " + this.responseCode);
            } else {
                JSONObject weatherData = getJsonObject(url);

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
                    forecastCollection.addObjectToForecastList(dayWeather);
                }
            }
        } catch (Exception e) {
            if(responseCode==200){
                DialogUtils.errorDialog("");
            }else{
                DialogUtils.errorDialog(String.valueOf(this.responseCode));
            }        }
        return forecastCollection;
    }

    public HttpURLConnection getHttpURLConnection(URL url) {
        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return conn;
    }

    private JSONObject getJsonObject(URL url) throws IOException, org.json.simple.parser.ParseException {
        StringBuilder informationString = Utils.getStringFromURL(url.openStream());
        JSONParser parse = new JSONParser();
        return (JSONObject) parse.parse(String.valueOf(informationString));
    }

    private void addDataToObjDayWeather(JSONArray tempMaxArray, JSONArray tempMinArray, JSONArray feelsLikeArray, JSONArray feelsLikeMinArray, JSONArray windSpeedArray, JSONArray windDirectionArray, JSONArray timeArray, JSONArray precipitationArray, int i, int code, ForecastWeather dayWeather, Location location) throws ParseException {
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

