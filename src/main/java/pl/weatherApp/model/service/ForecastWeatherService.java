package pl.weatherApp.model.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.Converters;
import pl.weatherApp.model.utils.DialogUtils;

import java.net.HttpURLConnection;
import java.net.URL;

public class ForecastWeatherService {

    public ForecastWeatherService(){}

    public void init(LocationService localizationService){
        int days = 5; //todo user set days

        try {
            URL url = new URL(WeatherClient.getForecastURL(localizationService));

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode_Forecast: " + responseCode);
            } else {
                ApiUtils.informationString = ApiUtils.getStringFromURL(url.openStream());
                JSONParser parse = new JSONParser();
                JSONObject weatherData = (JSONObject) parse.parse(String.valueOf(ApiUtils.informationString));

                JSONObject weatherDataObj = (JSONObject) weatherData.get("daily_units");
                String tempUnit = (String) weatherDataObj.get("temperature_2m_max");
                String speedUnit = (String) weatherDataObj.get("wind_speed_10m_max");
                String directionUnit = (String) weatherDataObj.get("wind_direction_10m_dominant");
                String precipitationUnit = (String) weatherDataObj.get("precipitation_sum");

                Units units = new Units();
                units.setTemp(tempUnit);
                units.setSpeed(speedUnit);
                units.setDirection(directionUnit);
                units.setPrecipitation(precipitationUnit);
                WeatherCollection.addObjectToUnitsList(units);

                JSONObject dailyObj = (JSONObject) weatherData.get("daily");

                JSONArray tempMaxArray = (JSONArray) dailyObj.get("temperature_2m_max");
                JSONArray tempMinArray = (JSONArray) dailyObj.get("temperature_2m_min");
                JSONArray feelsLikeArray = (JSONArray) dailyObj.get("apparent_temperature_max");
                JSONArray feelsLikeMinArray = (JSONArray) dailyObj.get("apparent_temperature_min");
                JSONArray windSpeedArray = (JSONArray) dailyObj.get("wind_speed_10m_max");
                JSONArray windDirectionArray = (JSONArray) dailyObj.get("wind_direction_10m_dominant");
                JSONArray timeArray = (JSONArray) dailyObj.get("time");
                JSONArray weatherCodeArray = (JSONArray) dailyObj.get("weather_code");
                JSONArray precipitationArray = (JSONArray) dailyObj.get("precipitation_sum");

                for (int i = 0; i < days; i++) {
                    int code = Converters.convertLongToIntArray(weatherCodeArray, i);
                    ForecastWeather dayWeather = new ForecastWeather();

                    addDataToObjDayWeather(tempMaxArray, tempMinArray, feelsLikeArray, feelsLikeMinArray, windSpeedArray, windDirectionArray, timeArray, precipitationArray, i, code, dayWeather);

                    WeatherCollection.addObjectToForecastList(dayWeather);

                    writeOutVariables(tempUnit, speedUnit, directionUnit, windSpeedArray, windDirectionArray, i, code, dayWeather);
                }
            }
        } catch (Exception e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }

    private static void addDataToObjDayWeather(JSONArray tempMaxArray, JSONArray tempMinArray, JSONArray feelsLikeArray, JSONArray feelsLikeMinArray, JSONArray windSpeedArray, JSONArray windDirectionArray, JSONArray timeArray, JSONArray precipitationArray, int i, int code, ForecastWeather dayWeather) {
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

    private static void writeOutVariables(String tempUnit, String speedUnit, String directionUnit, JSONArray windSpeedArray, JSONArray windDirectionArray, int i, int code, ForecastWeather dayWeather) {
        System.out.println("tempMin " + dayWeather.getTempMin());
        System.out.println("tempfeelMin " + dayWeather.getFeels_likeMin());

        System.out.println(dayWeather.getTime() + " " + dayWeather.getTempMax() + " "+ dayWeather.getTempMin()+ tempUnit + " odczuwalna: " + dayWeather.getFeels_likeMax() + " "+ dayWeather.getFeels_likeMin()+ tempUnit + " opady: " + dayWeather.getPrecipitation() + WeatherCollection.getWeatherUnits(0).getPrecipitation() + " wiatr: " + windSpeedArray.get(i) + speedUnit + " kierunek: " + windDirectionArray.get(i) + directionUnit + " kod: " + WeatherCodes.mapCodes(code));

//        System.out.println(WeatherCollection.getForecastList(0).getTime()+" "+WeatherCollection.getForecastList(0).getFeels_likeMax());
    }

}

