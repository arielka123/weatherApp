package pl.weatherApp.model.utils;

import org.json.simple.JSONArray;

public class Converters {

    public static int convertDoubleToInt(double name){
        return (int) Math.round(name);
    }

    public static int convertLongToIntArray(JSONArray Array, int i) {
        long nameL = (Long) Array.get(i);
        return Math.toIntExact(nameL);
    }

    public static int convertDoubleToIntArray(JSONArray Array, int i) {
        double nameD = (double) Array.get(i);
        return (int) Math.round(nameD);
    }

}
