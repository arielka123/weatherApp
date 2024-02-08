package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.client.WeatherClient;
import pl.weatherApp.model.objects.ForecastWeather;
import pl.weatherApp.model.objects.Location;
import pl.weatherApp.model.objects.collections.ForecastCollection;
import pl.weatherApp.model.objects.collections.WeatherCodes;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.DateManager;
import pl.weatherApp.model.utils.DialogUtils;
import pl.weatherApp.model.utils.Utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForecastWeatherService implements IWeatherService {
    ForecastWeather forecastWeather;
    private int responseCode;
    String countryCode;
    String weatherCode;
    String date;
    String dayOfWeek;
    Integer tempMax;
    Integer tempMin;
    Integer feels_likeMax;
    Integer feels_likeMin;
    Double precipitation;
    Double windSpeed;
    Integer windDirection;

    public ForecastWeatherService() {
    }

    public ForecastCollection init(Location location) {
        int days = 16;
        ForecastCollection forecastCollection = new ForecastCollection();

        try {
            URL url = WeatherClient.getForecastURL(location);
            HttpURLConnection conn = ApiUtils.getHttpURLConnection(url);
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

                    if (windDirectionArray.get(i) != null) {
                        forecastWeather = new ForecastWeather();
                        date = (String) timeArray.get(i);
                        weatherCode = WeatherCodes.mapCodes(code);
                        tempMax = Utils.convertDoubleToIntArray(tempMaxArray, i);
                        tempMin = Utils.convertDoubleToIntArray(tempMinArray, i);
                        feels_likeMax = Utils.convertDoubleToIntArray(feelsLikeMaxArray, i);
                        feels_likeMin = Utils.convertDoubleToIntArray(feelsLikeMinArray, i);
                        windSpeed = (Double) windSpeedArray.get(i);
                        windDirection = Utils.convertLongToIntArray(windDirectionArray, i);
                        precipitation = (Double) precipitationArray.get(i);
                        countryCode = location.getCountry_code();
                        dayOfWeek = DateManager.getDayOfWeek(date);

                        forecastWeather = new ForecastWeather(countryCode, weatherCode, date, dayOfWeek, tempMax, tempMin, feels_likeMin, feels_likeMax, precipitation, windSpeed, windDirection);

                        forecastCollection.addObjectToForecastList(forecastWeather);
                    }
                }
            }
        } catch (Exception e) {
            if (responseCode == 200) {
                DialogUtils.errorDialog("");
            } else {
                DialogUtils.errorDialog(String.valueOf(this.responseCode));
            }
        }
        return forecastCollection;
    }

    public int getResponseCode() {
        return responseCode;
    }

//    public HttpURLConnection getHttpURLConnection(URL url) {
//        HttpURLConnection conn;
//        try {
//            conn = (HttpURLConnection) url.openConnection();
//            conn.connect();
//        } catch (IOException e) {
//            throw new RuntimeException();
//        }
//        return conn;
//    }

    private JSONObject getJsonObject(URL url) throws IOException, org.json.simple.parser.ParseException {
        StringBuilder informationString = Utils.getStringFromURL(url.openStream());
        JSONParser parse = new JSONParser();
        return (JSONObject) parse.parse(String.valueOf(informationString));
    }


}

