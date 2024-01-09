package pl.weatherApp.model.collections;

import pl.weatherApp.model.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class DaysWeek {
    public static String mapCodes(int key) {
        Map<Integer, String> mapCode = new HashMap<>();
        mapCode.put(1, Utils.getBundle("day.Sunday"));
        mapCode.put(2, Utils.getBundle("day.Monday"));
        mapCode.put(3, Utils.getBundle("day.Tuesday"));
        mapCode.put(4, Utils.getBundle("day.Wednesday"));
        mapCode.put(5, Utils.getBundle("day.Thursday"));
        mapCode.put(6, Utils.getBundle("day.Friday"));
        mapCode.put(7, Utils.getBundle("day.Saturday"));
        return mapCode.get(key);
    }
}
