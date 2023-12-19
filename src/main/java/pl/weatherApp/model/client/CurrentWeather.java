package pl.weatherApp.model.client;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.weatherApp.model.utils.ApiUtils;
import pl.weatherApp.model.utils.DialogUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrentWeather extends Weather {

//    Double temp;  //oC
//    Long humidity;   //%
//    Long pressure; //hPa
//    Double feels_like;
//    Long visibility; //km
////    String description;
//    Long clouds; //%
    public CurrentWeather(){
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
                Object obj = parse.parse(String.valueOf(ApiUtils.informationString));
                JSONObject weatherData = ApiUtils.getJsonObject(obj);

                Object objMain = parse.parse(String.valueOf(weatherData.get("main")));
                JSONObject weatherDataMain = ApiUtils.getJsonObject(objMain);

                Object objClouds = parse.parse(String.valueOf(weatherData.get("clouds")));
                JSONObject weatherDataClouds = ApiUtils.getJsonObject(objClouds);

//                Object objDesc = parse.parse(String.valueOf(weatherData.get("weather")));
//                JSONArray arrayWeather = new JSONArray();
//                arrayWeather.add(objDesc);

//                JSONArray array1 = (JSONArray) arrayWeather.get(0);


//                JSONObject x = (JSONObject) arrayWeather.get(0);

                System.out.println(weatherData.get("main"));
                System.out.println(weatherData.get("weather"));
                System.out.println(weatherData.get("clouds"));


//                Object objWeather = parse.parse(String.valueOf(weatherData.get("weather")));
//                JSONArray arrayWeather = new JSONArray();
//                arrayWeather.add(objWeather);

//                description = (String) weatherDataWeather.get("description");
//                System.out.println(description);

                Weather.temp = (Double) weatherDataMain.get("temp");
                Weather.humidity = (Long) weatherDataMain.get("humidity");
                Weather.pressure = (Long) weatherDataMain.get("pressure");
                Weather.feels_like = (Double) weatherDataMain.get("feels_like");
                Weather.visibility = (Long) weatherData.get("visibility");
                Weather.clouds = (Long) weatherDataClouds.get("all");
            }
            } catch (IOException | ParseException | RuntimeException e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }
}
