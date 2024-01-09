package pl.weatherApp.model.collections;

import pl.weatherApp.model.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class WeatherCodes {

    public static String mapCodes(int key){
        Map<Integer, String> mapCode = new HashMap<>();
        mapCode.put(0, Utils.getBundle("weather.clearSky"));
        mapCode.put(1,Utils.getBundle("weather.mainlyClear"));
        mapCode.put(2,Utils.getBundle("weather.partlyCloud"));
        mapCode.put(3,Utils.getBundle("weather.overcast"));
        mapCode.put(45,Utils.getBundle("weather.fog"));
        mapCode.put(48,Utils.getBundle("weather.fog"));
        mapCode.put(51,Utils.getBundle("weather.drizzle"));
        mapCode.put(53,Utils.getBundle("weather.drizzle"));
        mapCode.put(55,Utils.getBundle("weather.drizzle"));
        mapCode.put(56,Utils.getBundle("weather.drizzle"));
        mapCode.put(57,Utils.getBundle("weather.drizzle"));
        mapCode.put(61,Utils.getBundle("weather.rain"));
        mapCode.put(63,Utils.getBundle("weather.rain"));
        mapCode.put(65,Utils.getBundle("weather.rain"));
        mapCode.put(66,Utils.getBundle("weather.rain"));
        mapCode.put(67,Utils.getBundle("weather.rain"));
        mapCode.put(71,Utils.getBundle("weather.snowFall"));
        mapCode.put(73,Utils.getBundle("weather.snowFall"));
        mapCode.put(75,Utils.getBundle("weather.snowFall"));
        mapCode.put(77,Utils.getBundle("weather.snowGrains"));
        mapCode.put(80,Utils.getBundle("weather.rainShowers"));
        mapCode.put(81,Utils.getBundle("weather.rainShowers"));
        mapCode.put(82,Utils.getBundle("weather.rainShowers"));
        mapCode.put(85,Utils.getBundle("weather.snowShowers"));
        mapCode.put(86,Utils.getBundle("weather.snowShowers"));
        mapCode.put(95,Utils.getBundle("weather.thunderstorm"));
        mapCode.put(96,Utils.getBundle("weather.thunderstorm"));
        mapCode.put(99,Utils.getBundle("weather.thunderstorm"));
        return mapCode.get(key);
    }

}
