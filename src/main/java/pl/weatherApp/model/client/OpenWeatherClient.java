package pl.weatherApp.model.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.weatherApp.model.utils.DialogUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class OpenWeatherClient extends WeatherClient{

    static String cityName = "Warszawa";
    Double temp;  //oC
    Long humidity;   //%
    Long pressure; //hPa
    Double feels_like;
    Long visibility; //km
    String description;
    Long clouds; //%

    {
        try {
            URL url = new URL(CurrentWeather.getURL());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                //todo Dialog zrobic
                throw new RuntimeException("HttpResponseCode: " + responseCode);

            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();

                JSONParser parse = new JSONParser();
                Object obj = parse.parse(String.valueOf(informationString));
                JSONArray array = new JSONArray();
                array.add(obj);
                JSONObject weatherData = (JSONObject) array.get(0);

                Object objMain = parse.parse(String.valueOf(weatherData.get("main")));
                JSONArray arrayMain = new JSONArray();
                arrayMain.add(objMain);
                JSONObject weatherDataMain = (JSONObject) arrayMain.get(0);

                Object objClouds = parse.parse(String.valueOf(weatherData.get("clouds")));
                JSONArray arrayClouds = new JSONArray();
                arrayClouds.add(objClouds);
                JSONObject weatherDataClouds = (JSONObject) arrayClouds.get(0);

                Object objDesc = parse.parse(String.valueOf(weatherData.get("weather")));
                JSONArray arrayWeather = new JSONArray();
                arrayWeather.add(objDesc);

                System.out.println(arrayWeather);
                System.out.println(arrayWeather.get(0));
                System.out.println(arrayWeather.size());

//                JSONArray array1 = (JSONArray) arrayWeather.get(0);


//                JSONObject x = (JSONObject) arrayWeather.get(0);

                System.out.println(weatherData.get("description"));

                System.out.println(weatherData.get("main"));
                System.out.println(weatherData.get("weather"));
                System.out.println(weatherData.get("clouds"));


//                Object objWeather = parse.parse(String.valueOf(weatherData.get("weather")));
//                JSONArray arrayWeather = new JSONArray();
//                arrayWeather.add(objWeather);

//                description = (String) weatherDataWeather.get("description");
//                System.out.println(description);

                temp = (Double) weatherDataMain.get("temp");
                humidity = (Long) weatherDataMain.get("humidity");
                pressure = (Long) weatherDataMain.get("pressure");
                feels_like = (Double) weatherDataMain.get("feels_like");
                visibility = (Long) weatherData.get("visibility");
                clouds = (Long) weatherDataClouds.get("all");

            }
            } catch (IOException | ParseException | RuntimeException e) {
            DialogUtils.errorDialog(e.getMessage());
        }
    }
}
