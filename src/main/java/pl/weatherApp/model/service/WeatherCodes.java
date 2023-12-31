package pl.weatherApp.model.service;

import java.util.HashMap;
import java.util.Map;

public class WeatherCodes {

    public static String mapCodes(int key){
        Map<Integer, String> mapCode = new HashMap<>();
        mapCode.put(0, "clear sky");
        mapCode.put(1, "mainly clear");
        mapCode.put(2, "partly cloudy");
        mapCode.put(3, "overcast");
        mapCode.put(45, "fog");
        mapCode.put(48, "fog");
        mapCode.put(51, "Drizzle");
        mapCode.put(53, "Drizzle");
        mapCode.put(55, "Drizzle");
        mapCode.put(56, "Drizzle");
        mapCode.put(57, "Drizzle");
        mapCode.put(61, "Rain");
        mapCode.put(63, "Rain");
        mapCode.put(65, "Rain");
        mapCode.put(66, "Rain");
        mapCode.put(67, "Rain");
        mapCode.put(71, "Snow fall");
        mapCode.put(73, "Snow fall");
        mapCode.put(75, "Snow fall");
        mapCode.put(77, "Snow grains");
        mapCode.put(80, "Rain showers");
        mapCode.put(81, "Rain showers");
        mapCode.put(82, "Rain showers");
        mapCode.put(85, "Snow showers");
        mapCode.put(86, "Snow showers");
        mapCode.put(95, "Thunderstorm");
        mapCode.put(96, "Thunderstorm");
        mapCode.put(99, "Thunderstorm");
        return mapCode.get(key);
    }
}
