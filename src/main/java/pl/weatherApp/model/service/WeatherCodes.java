package pl.weatherApp.model.service;

import pl.weatherApp.model.utils.FxmlUtils;

import java.util.HashMap;
import java.util.Map;

public class WeatherCodes {

    public static String mapCodes(int key){
        Map<Integer, String> mapCode = new HashMap<>();
        mapCode.put(0, getBundles("weather.mainlyClear"));
        mapCode.put(1, getBundles("weather.mainlyClear"));
        mapCode.put(2, getBundles("weather.partlyCloud"));
        mapCode.put(3, getBundles("weather.overcast"));
        mapCode.put(45, getBundles("weather.fog"));
        mapCode.put(48, getBundles("weather.fog"));
        mapCode.put(51, getBundles("weather.drizzle"));
        mapCode.put(53, getBundles("weather.drizzle"));
        mapCode.put(55, getBundles("weather.drizzle"));
        mapCode.put(56, getBundles("weather.drizzle"));
        mapCode.put(57, getBundles("weather.drizzle"));
        mapCode.put(61, getBundles("weather.rain"));
        mapCode.put(63, getBundles("weather.rain"));
        mapCode.put(65, getBundles("weather.rain"));
        mapCode.put(66, getBundles("weather.rain"));
        mapCode.put(67, getBundles("weather.rain"));
        mapCode.put(71, getBundles("weather.snowFall"));
        mapCode.put(73, getBundles("weather.snowFall"));
        mapCode.put(75, getBundles("weather.snowFall"));
        mapCode.put(77, getBundles("weather.snowGrains"));
        mapCode.put(80, getBundles("weather.rainShowers"));
        mapCode.put(81, getBundles("weather.rainShowers"));
        mapCode.put(82, getBundles("weather.rainShowers"));
        mapCode.put(85, getBundles("weather.rainShowers"));
        mapCode.put(86, getBundles("weather.rainShowers"));
        mapCode.put(95, getBundles("weather.thunderstorm"));
        mapCode.put(96, getBundles("weather.thunderstorm"));
        mapCode.put(99, getBundles("weather.thunderstorm"));
        return mapCode.get(key);
    }

    private static String getBundles(String name){
        return FxmlUtils.getResourceBundle().getString(name);
    }
}
